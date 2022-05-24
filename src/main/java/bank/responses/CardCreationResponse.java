package bank.responses;

import bank.dto.CardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CardCreationResponse {

    private CardDto cardDto;

    public CardCreationResponse(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an card with this CVC.");
    }

    public ResponseEntity<CardDto> onSuccess() {
        return ResponseEntity.ok().body(cardDto);
    }
}
