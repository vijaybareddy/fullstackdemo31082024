package com.fullstackdemo_31082024.fullstackdemo_31082024.Repository;

import entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    // This method can be removed as it duplicates findByAccountnumberAndPan
    // AccountEntity getAccountEntity(@Param("accountnumber") String accountnumber,
    //                                 @Param("pan") String pan);

    // Ensure that the field names in AccountEntity match the parameter names
    AccountEntity findByAccountnumberAndPan(@Param("accountnumber") String accountnumber,
                                            @Param("pan") String pan);

    List<AccountEntity> findByBalanceLessThan(@Param("balance") double balance);

    List<AccountEntity> findByBalanceGreaterThan(@Param("balance") double balance);

    List<AccountEntity> findByBalanceBetween(double lowrange, double upperrange);
}
