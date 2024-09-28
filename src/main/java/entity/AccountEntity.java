package entity;

import entity.AccountAddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "account", schema = "bank")
@Data
@AllArgsConstructor
@NoArgsConstructor  // Added for easier use by frameworks
public class AccountEntity {

    @Id
    @Column(name = "accountnumber")
    private String accountNumber;  // Use camelCase for field name

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pan", nullable = false)
    private String pan;

    @Column(name = "mobilenumber", nullable = false)  // Corrected column name
    private String mobileNumber;

    @Column(name = "balance", nullable = false)
    private double balance;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "accountEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountAddressEntity> accountAddressEntityList;
}
