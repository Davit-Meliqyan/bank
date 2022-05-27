package bank.mappers;

import bank.dto.CardDto;
import bank.model.Card;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

@Component
public class CardMapper {

    public Card toCard(CardDto cardDto) {

        Card card = new Card();

        card.setCardType(cardDto.getCardType());
        card.setExpirationDate(cardDto.getExpirationDate());
        card.setAccount(cardDto.getAccount());

        return card;
    }

    public CardDto toCardDto(Card card) {

        CardDto cardDto = new CardDto();

        cardDto.setPin(card.getPin());
        // cardDto.setCVC(card.getCVC());
        cardDto.setCardStatus(card.getCardStatus());
        cardDto.setCardType(card.getCardType());
        cardDto.setExpirationDate(card.getExpirationDate());
        cardDto.setAccount(card.getAccount());

        return cardDto;
    }

    public List<CardDto> mapAllToCardDto(List<Card> cards) {
        return cards.stream()
                .map(this::toCardDto)
                .collect(Collectors.toList());
    }

}
