package com.repository;

import com.domain.User;

public interface AccountRepository {

    public void insert(User user);


    public User getUser(User user);

    public void update(User user);

    public User get(String username);
}
