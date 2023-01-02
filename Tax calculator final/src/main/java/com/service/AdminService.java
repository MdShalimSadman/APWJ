package com.service;

import com.domain.Admin;

public interface AdminService {


    public void insert(Admin admin);

    public void update(Admin admin);

    public Admin getAdmin(Admin admin);

    public Admin get(String username);

}
