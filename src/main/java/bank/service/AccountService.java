package bank.service;

import bank.dto.AccountDto;
import bank.dto.CardDto;
import bank.exception.ResourceNotFoundException;
import bank.mappers.AccountMapper;
import bank.model.Account;
import bank.model.Card;
import bank.repository.AccountRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public Optional<AccountDto> createAccount(AccountDto accountDto) {
        String IBAN;
        while (true){
            IBAN = RandomStringUtils.randomNumeric(24);
            if (!accountRepository.existsByIBAN(IBAN)) {
                break;
            }
        }

        Account accountToSave = this.accountMapper.toAccount(accountDto);

        accountToSave.setIBAN(IBAN);

        Account savedAccount = this.accountRepository.save(accountToSave);

        return Optional.of(
                this.accountMapper.toAccountDto(savedAccount)
        );
    }

    public Optional<AccountDto> getAccount(Long id) {

        Optional<Account> account = this.accountRepository.findById(id);
        if (account.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(
                this.accountMapper.toAccountDto(account.get())
        );
    }

    public void deleteAccount(Long id) {

        Optional<Account> account = this.accountRepository.findById(id);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account not found");
        }
        accountRepository.delete(account.get());
    }
}
