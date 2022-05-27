package bank.service;

import bank.dto.CardDto;
import bank.exception.ResourceNotFoundException;
import bank.mappers.CardMapper;
import bank.model.Card;
import bank.model.enums.CardStatus;
import bank.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;


@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public Optional<CardDto> createCard(CardDto cardDto) {
        String cardNumber;
        do {
            cardNumber = RandomStringUtils.randomNumeric(16);
        } while (cardRepository.existsByCardNumber(cardNumber));

        Card cardToSave = this.cardMapper.toCard(cardDto);

        cardToSave.setCardStatus(CardStatus.CREATED);
        cardToSave.setCVC(RandomStringUtils.randomNumeric(3));
        cardToSave.setCardNumber(cardNumber);

        Card savedCard = this.cardRepository.save(cardToSave);

        return Optional.of(
                this.cardMapper.toCardDto(savedCard)
        );
    }

    public Optional<CardDto> getCard(Long id) {

        Optional<Card> card = this.cardRepository.findById(id);
        if (card.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(
                this.cardMapper.toCardDto(card.get())
        );
    }

    public void deleteCard(Long id) {

        Optional<Card> card = this.cardRepository.findById(id);
        if (card.isEmpty()) {
            throw new ResourceNotFoundException("Card not found");
        }
        cardRepository.delete(card.get());
    }

    public void activateCard(Long id, String pin) {

        Optional<Card> card = this.cardRepository.findById(id);
        if (card.isEmpty()) {
            throw new ResourceNotFoundException("Card not found");
        }
        if (card.get().getCardStatus().equals(CardStatus.ACTIVE)) {
            throw new ResourceNotFoundException("The card  already activated");
        }
        card.get().setPin(pin);
        card.get().setCardStatus(CardStatus.ACTIVE);

        cardRepository.save(card.get());
    }

    public Optional<CardDto> updateCard(Long id, CardDto cardDto) {

        //Card card = cardRepository.findById(id).get();
        Optional<Card> card = this.cardRepository.findById(id);
        if (card.isEmpty()) {
            throw new ResourceNotFoundException("Card not found");
        }

        card.get().setPin(cardDto.getPin());
        card.get().setAccount(cardDto.getAccount());
        card.get().setCardType(cardDto.getCardType());


        cardRepository.save(card.get());
        return Optional.of(cardDto);
    }
}
