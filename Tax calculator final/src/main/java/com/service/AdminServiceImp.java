package com.service;

import com.domain.Admin;
import com.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImp implements AdminService{

    private final AdminRepository adminRepository;

    public AdminServiceImp(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    @Override
    public void insert(Admin admin) {
        adminRepository.insert(admin);
    }




    @Override
    public void update(Admin admin) {

    }


    @Override
    public Admin get(String username) {
        return adminRepository.get(username);
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return adminRepository.getAdmin(admin);
    }
}
