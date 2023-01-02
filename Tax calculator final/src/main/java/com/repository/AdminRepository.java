package com.repository;

import com.domain.Admin;

public interface AdminRepository {

    public void insert(Admin admin);

    public Admin getAdmin(Admin admin);

    public void update(Admin admin);

    public Admin get(String username);
}
