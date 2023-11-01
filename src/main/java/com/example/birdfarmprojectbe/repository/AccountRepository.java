package com.example.birdfarmprojectbe.repository;

import com.example.birdfarmprojectbe.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("Select Account from Account a where a.role.id = :roleID")
    public List<Account> getAccountByRole(Integer roleID);

    @Query("Select Account from Account where accountName = :accountname")
    Optional<Account> findAccountByAccountId(String accountname);
}
