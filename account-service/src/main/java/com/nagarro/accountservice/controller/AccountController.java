package com.nagarro.accountservice.controller;

import com.nagarro.accountservice.entity.Account;
import com.nagarro.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }

    @PostMapping("/{customerId}")
    public Account create(@PathVariable Long customerId) { return service.create(customerId); }

    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestParam Double amount) { return service.deposit(id, amount); }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestParam Double amount) { return service.withdraw(id, amount); }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id) { return service.get(id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
