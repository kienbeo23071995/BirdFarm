package com.example.birdfarmprojectbe.api;

import com.example.birdfarmprojectbe.dto.AccountDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/home/")
@AllArgsConstructor
public class PublicAPI {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO){
        return null;
    }
}
