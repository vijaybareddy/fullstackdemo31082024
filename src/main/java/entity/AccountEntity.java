package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "account",schema = "bank")
@Entity
@Data
public class AccountEntity {
    public AccountEntity(){

    }

    @Column(name = "name",nullable = false)
    private String name;
    @Id
    @Column(name = "accountnumber",nullable = false)
    private String accountnumber;
    @Column(name = "pan",nullable = false)
    private String pan;
    @Column(name = "moblieNumber",nullable = false)
    private String moblieNumber;
    @Column(name = "balance",nullable = false)
    private double balance;
    @Column(name = "address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "accountEntity",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    public List<AccountAddressEntity> accountAddressEntityList;




}
