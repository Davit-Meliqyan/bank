package bank.model;

import javax.persistence.*;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "iban",length = 24,
            nullable = false)
    private String IBAN;

    @Column(name = "balance", nullable = false)
    private String balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",
            foreignKey = @ForeignKey(name = "customer_account_fk"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuer_id",
            foreignKey = @ForeignKey(name = "issuer_account_fk"))
    private Issuer issuer;

    public Account() {
    }

    public Account(Long id, String IBAN, String balance, Customer customer, Issuer issuer) {
        this.id = id;
        this.IBAN = IBAN;
        this.balance = balance;
        this.customer = customer;
        this.issuer = issuer;
    }

    public Account(Long id, String IBAN, String balance) {
        this.id = id;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBalance() {
        return balance;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
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
}
