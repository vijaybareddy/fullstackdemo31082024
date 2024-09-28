package com.fullstackdemo_31082024.fullstackdemo_31082024.Repository;

import entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query("select a from AccountEntity a left join fetch a.accountAddressEntityList ad " +
            "where a.accountNumber = :accountNumber and ad.status = :status")
    AccountEntity getAccountEntityAddress(@Param("accountNumber") String accountNumber,
                                          @Param("status") Integer status);

    // Find by accountNumber and PAN
    AccountEntity findByAccountNumberAndPan(@Param("accountNumber") String accountNumber,
                                            @Param("pan") String pan);

    // Find by balance less than the provided amount
    List<AccountEntity> findByBalanceLessThan(@Param("balance") double balance);

    // Find by balance greater than the provided amount
    List<AccountEntity> findByBalanceGreaterThan(@Param("balance") double balance);

    // Find by balance between two ranges
    List<AccountEntity> findByBalanceBetween(double lowrange, double upperrange);
}
