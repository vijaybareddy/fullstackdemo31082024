package com.fullstackdemo_31082024.fullstackdemo_31082024.Service;

import com.fullstackdemo_31082024.fullstackdemo_31082024.Repository.AccountRepository;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Account;
import com.fullstackdemo_31082024.fullstackdemo_31082024.model.Address;
import entity.AccountAddressEntity;
import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceWithJpa {


    @Autowired
    AccountRepository accountRepository;

    public List<AccountEntity> accountLessThanBalance(double balance){
        return accountRepository.findByBalanceLessThan(balance);
    }

    public List<AccountEntity> accountGreaterThanBalance(double balance){
        return accountRepository.findByBalanceGreaterThan(balance);
    }


    public List<AccountEntity> accountBetweenBalance(double lowerRange, double upperRange) {
        return accountRepository.findByBalanceBetween(lowerRange, upperRange);
    }

//    public List<AccountEntity> findAccountsWithNullBalance(){
//        return accountRepositary2.findByBalanceIsNull();
//    }
//
//    public List<AccountEntity> findAccountsWithBalanceNotNull(){
//        return accountRepositary2.findByBalanceIsNotNull();
//    }
//
//    public List<AccountEntity> findDistinctAccountsByBalance(double balance){
//        return accountRepositary2.findByDistinctByBalance(balance);
//    }

    public Account searchAccountByAccountAndPan(String accountnumber, String pan){
        Account account=null;
        AccountEntity accountEntity =accountRepository.findByAccountnumberAndPan(accountnumber,pan);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobileNumber(accountEntity.getMoblieNumber())
                    .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountAddressEntity> accountAddressEntityList =
                    accountEntity.getAccountAddressEntityList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountAddressEntity accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAddress1());
                address.setAdd2(accountAddressEntity.getAddress2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setStates(accountAddressEntity.getState());

                account.setAddress(address);
            }
        }
        return account;
    }

/*

    public Account searchAccountByAccountAndPanJPQL(String accountnumber, String pan){
        Account account=null;
        AccountEntity accountEntity =accountRepository.getAccountEntity(accountnumber,pan);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountnumber())
                    .mobileNumber(accountEntity.getAccountnumber())
                    .balance(accountEntity.getBalance())
                    .pan(accountEntity.getPan())
                    .name(accountEntity.getName()).build();
            List<AccountAddressEntity> accountAddressEntityList =
                    accountEntity.getAccountAddressEntityList();
            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
                AccountAddressEntity accountAddressEntity = accountAddressEntityList.get(0);
                Address address = new Address();
                address.setAdd1(accountAddressEntity.getAddress1());
                address.setAdd2(accountAddressEntity.getAddress2());
                address.setCity(accountAddressEntity.getCity());
                address.setPincode(accountAddressEntity.getPincode());
                address.setStates(accountAddressEntity.getState());

                account.setAddress(address);
            }
        }
        return account;
    }
*/


}
