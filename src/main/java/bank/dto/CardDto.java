package bank.dto;

import bank.model.Account;
import bank.model.enums.CardStatus;
import bank.model.enums.CardType;

import java.time.LocalDate;

public class CardDto {

   // private String CVC;
    private CardStatus cardStatus;
    private CardType cardType;
    private String pin;
    private LocalDate expirationDate;
    private String cardNumber;


    public CardDto() {
    }

    public CardDto(CardStatus cardStatus, CardType cardType, String pin, LocalDate expirationDate, String cardNumber) {
        this.cardStatus = cardStatus;
        this.cardType = cardType;
        this.pin = pin;
        this.expirationDate = expirationDate;
        this.cardNumber = cardNumber;
    }

    public CardDto(Long id, CardStatus cardStatus, CardType cardType, String pin, LocalDate expirationDate, String CVC) {
        this.cardStatus = cardStatus;
        this.cardType = cardType;
        this.pin = pin;
        this.expirationDate = expirationDate;
      //  this.CVC = CVC;
    }

//    public String getCVC() {
//        return CVC;
//    }
//
//    public void setCVC(String CVC) {
//        this.CVC = CVC;
//    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
