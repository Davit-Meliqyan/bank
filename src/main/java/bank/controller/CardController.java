package bank.controller;

import bank.dto.CardDto;
import bank.responses.CardCreationResponse;
import bank.responses.CardLookupResponse;
import bank.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/Cards")
public class CardController {

    CardService cardService;

    CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<?> createCard(@RequestBody CardDto Card) {
        Assert.notNull(Card, "Card passed is null!");
        Optional<CardDto> emp = cardService.createCard(Card);
        if (emp.isEmpty()) {
            return new CardCreationResponse(Card).onFailure();
        }
        return new CardCreationResponse(emp.get()).onSuccess();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCard(@PathVariable("id") Long id) {
        Optional<CardDto> emp = cardService.getCard(id);
        if (emp.isPresent()) {
            return new CardLookupResponse(emp.get()).onSuccess();
        }
        return new CardLookupResponse(null).onFailure();
    }
}
