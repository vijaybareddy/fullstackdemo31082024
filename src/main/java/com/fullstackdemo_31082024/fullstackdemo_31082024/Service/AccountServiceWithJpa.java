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
    AccountRepository accountRepository2;
    public List<AccountEntity> accountLessThanBalance(double balance){
        return accountRepository2.findByBalanceLessThan(balance);
    }

    public List<AccountEntity> accountGreaterThanBalance(double balance){
        return accountRepository2.findByBalanceGreaterThan(balance);
    }


    public List<AccountEntity> accountBetweenBalance(double lowerRange, double upperRange) {
        return accountRepository2.findByBalanceBetween(lowerRange, upperRange);
}

    public Account searchAccountByAccountAndPan(String accountnumber, String pan){
        Account account=null;
        AccountEntity accountEntity =accountRepository2.findByAccountNumberAndPan(accountnumber,pan);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountNumber())
                    .mobileNumber(accountEntity.getMobileNumber())
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



//    public Account searchAccountByAccountAndPanJPQL(String accountnumber, String pan){
//        Account account=null;
//        AccountEntity accountEntity =accountRepository2.getAccountEntity(accountnumber,pan);
//        if(accountEntity!= null){
//
//            account=Account.builder()
//                    .accountnumber(accountEntity.getAccountnumber())
//                    .mobileNumber(accountEntity.getAccountnumber())
//                    .balance(accountEntity.getBalance())
//                    .pan(accountEntity.getPan())
//                    .name(accountEntity.getName()).build();
//            List<AccountAddressEntity> accountAddressEntityList =
//                    accountEntity.getAccountAddressEntityList();
//            if (Objects.nonNull(accountAddressEntityList) && accountAddressEntityList.size() > 0) {
//                AccountAddressEntity accountAddressEntity = accountAddressEntityList.get(0);
//                Address address = new Address();
//                address.setAdd1(accountAddressEntity.getAddress1());
//                address.setAdd2(accountAddressEntity.getAddress2());
//                address.setCity(accountAddressEntity.getCity());
//                address.setPincode(accountAddressEntity.getPincode());
//                address.setStates(accountAddressEntity.getState());
//
//                account.setAddress(address);
//            }
//        }
//        return account;
//    }

    public Account searchAccountByAccountAddressJPQL(String accountnumber,Integer status){
        Account account=null;
        AccountEntity accountEntity =accountRepository2.getAccountEntityAddress(accountnumber,status);
        if(accountEntity!= null){

            account=Account.builder()
                    .accountnumber(accountEntity.getAccountNumber())
                    .mobileNumber(accountEntity.getMobileNumber())
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
//public Account searchAccountByAddressStatusJPQL(String accountnumber, String pan) {
//    Account account = null;
//
//    AccountEntity  accountEntity = accountRepository2.getAccountEntityAddress(accountnumber, 1);
//
//    if(accountEntity!=null){
//        account = Account.builder()
//                .accountnumber(accountEntity.getAccountnumber())
//                .mobileNumber(accountEntity.getMobileNumber())
//                .balance(accountEntity.getBalance())
//                .pan(accountEntity.getPan())
//                .name(accountEntity.getName())
//                .build();
//
//        // If only one address is needed, just check for the first one
//        if (accountEntity.getAccountAddressEntityList() != null && !accountEntity.getAccountAddressEntityList().isEmpty()) {
//            AccountAddressEntity accountAddressEntity = accountEntity.getAccountAddressEntityList().get(0);
//
//            Address address = new Address();
//            address.setAdd1(accountAddressEntity.getAddress1());
//            address.setAdd2(accountAddressEntity.getAddress2());
//            address.setCity(accountAddressEntity.getCity());
//            address.setPincode(accountAddressEntity.getPincode());
//            address.setStates(accountAddressEntity.getState());
//
//            account.setAddress(address);
//        }
//    }
//
//    return account;
//}searchAccountByAccountAddressJPQL


}
