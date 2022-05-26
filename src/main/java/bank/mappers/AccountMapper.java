package bank.mappers;

import bank.dto.AccountDto;
import bank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toAccount(AccountDto accountDto) {

        Account account = new Account();

        account.setIssuer(accountDto.getIssuer());
        account.setCustomer(accountDto.getCustomer());
        account.setBalance(accountDto.getBalance());

        return account;
    }

    public AccountDto toAccountDto(Account account) {

        AccountDto accountDto = new AccountDto();

        accountDto.setIssuer(account.getIssuer());
        accountDto.setCustomer(account.getCustomer());
        accountDto.setBalance(account.getBalance());

        return accountDto;
    }
}
