package com.nagarro.accountservice.service;


import com.nagarro.accountservice.entity.Account;
import com.nagarro.accountservice.repository.AccountRepository;
import com.nagarro.accountservice.webclient.CustomerClient;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository repository;
    private final CustomerClient customerClient;

    public AccountService(AccountRepository repo, AccountRepository repository, CustomerClient customerClient) {
        this.repository = repository;
        this.customerClient = customerClient;
    }

    public Account create(Long customerId) {
        customerClient.getCustomer(customerId);
        return repository.save(Account.builder().customerId(customerId).balance(0.0).build());
    }

    public Account deposit(Long id, Double amount) {
        Account account = repository.findById(id).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        return repository.save(account);
    }

    public Account withdraw(Long id, Double amount) {
        Account account = repository.findById(id).orElseThrow();
        if (account.getBalance() < amount) throw new RuntimeException("Insufficient funds");
        account.setBalance(account.getBalance() - amount);
        return repository.save(account);
    }

    public Account get(Long id) { return repository.findById(id).orElseThrow(); }
    public void delete(Long id) { repository.deleteById(id); }
}
