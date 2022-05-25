package bank.service;

import bank.dto.CardDto;
import bank.mappers.CardMapper;
import bank.model.Card;
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
        if (cardRepository.existsByCardNumber(RandomStringUtils.randomNumeric(16))) {
            return Optional.empty();
        }
        Card cardToSave = this.cardMapper.toCard(cardDto);

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
}
