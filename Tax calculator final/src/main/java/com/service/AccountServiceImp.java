package com.service;

import com.domain.User;
import com.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImp implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    @Override
    public void insert(User user) {
        accountRepository.insert(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(String username) {
        return accountRepository.get(username);
    }

    @Override
    public User getUser(User user) {
        return accountRepository.getUser(user);
    }
}
