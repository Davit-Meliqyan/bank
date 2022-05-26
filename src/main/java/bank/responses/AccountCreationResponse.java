package bank.responses;

import bank.dto.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountCreationResponse {
    private AccountDto accountDto;

    public AccountCreationResponse(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an account with this IBAN.");
    }

    public ResponseEntity<AccountDto> onSuccess() {
        return ResponseEntity.ok().body(accountDto);
    }
}
