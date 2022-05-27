package bank.responses;

import bank.dto.CardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CardUpdateResponse {
    private CardDto cardDto;

    public CardUpdateResponse(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card with given properties does not exist.");
    }

    public ResponseEntity<CardDto> onSuccess() {
        return ResponseEntity.ok().body(cardDto);
    }

}
