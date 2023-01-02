package com.service;

import com.domain.User;

public interface AccountService {


    public void insert(User user);

    public void update(User user);

    public User getUser(User user);

    public User get(String username);

}
