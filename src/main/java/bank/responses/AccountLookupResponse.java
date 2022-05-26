package bank.responses;

import bank.dto.AccountDto;
import bank.dto.CardDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountLookupResponse {
    private AccountDto accountDto;

    public AccountLookupResponse(AccountDto accountDto) {
        this.accountDto = accountDto;
    }


    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with given properties does not exist.");
    }

    public ResponseEntity<AccountDto> onSuccess() {
        return ResponseEntity.ok().body(accountDto);
    }
}
