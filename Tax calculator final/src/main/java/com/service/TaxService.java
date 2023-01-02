package com.service;

import com.domain.Tax;
import com.domain.User;
import com.repository.TaxRepository;

public interface TaxService {

    public void insert(Tax tax);

    public Tax get(String email);

}
