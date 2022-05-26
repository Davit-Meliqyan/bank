package bank.dto;

import bank.model.Customer;
import bank.model.Issuer;

public class AccountDto {


    private String balance;
    private Customer customer;
    private Issuer issuer;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public AccountDto() {
    }
}
