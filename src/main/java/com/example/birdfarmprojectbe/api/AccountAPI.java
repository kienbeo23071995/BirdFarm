package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.models.Account;
import com.example.birdfarmprojectbe.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/manager/bird")
@AllArgsConstructor
public class AccountAPI {
    private final AccountRepository accountRepository;

    @GetMapping("/getAccountsByRole")
    public ResponseEntity<List<Account>> getAccounts(@RequestParam("roleID") Integer roleID){
        return ResponseEntity.ok(accountRepository.getAccountByRole(roleID));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.ok(accountRepository.findAll());
    }

    @GetMapping("/getAccountDetail/{id}")
    public ResponseEntity<Account> getAccountDetailByID(@PathVariable Integer id){
        return ResponseEntity.ok(accountRepository.findById(id).get());
    }
}
