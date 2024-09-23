package com.fullstackdemo_31082024.fullstackdemo_31082024.Repository;

import entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface AccountRepository extends JpaRepository<AccountEntity,String> {
    }


