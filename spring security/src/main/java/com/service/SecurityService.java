package com.service;

import com.domain.Security;
import com.domain.Student;
import com.repository.SecurityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityService {

    private SecurityRepository securityRepository;

    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Transactional(readOnly = true)
    public boolean insert(Security security) {
      security.setUsername("oasik");
      security.setPassword("$2y$10$LqPYTOcJhvhV7oSWXG5L2OkVMdQ4F0IbBxCP1Eyh2eqD7n8qgRhU6");
        return securityRepository.create(security);
    }
}
