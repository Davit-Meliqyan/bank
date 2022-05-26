package bank.controller;

import bank.dto.AccountDto;
import bank.responses.AccountCreationResponse;
import bank.responses.AccountLookupResponse;
import bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Accounts")
public class AccountController {

    AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        Assert.notNull(accountDto, "Account passed is null!");
        Optional<AccountDto> emp = accountService.createAccount(accountDto);
        if (emp.isEmpty()) {
            return new AccountCreationResponse(accountDto).onFailure();
        }
        return new AccountCreationResponse(emp.get()).onSuccess();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable("id") Long id) {
        Optional<AccountDto> emp = accountService.getAccount(id);
        if (emp.isPresent()) {
            return new AccountLookupResponse(emp.get()).onSuccess();
        }
        return new AccountLookupResponse(null).onFailure();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>(
                "Account was deleted ", HttpStatus.OK
        );
    }
}
