package com.service;

import com.domain.Tax;
import com.domain.User;
import com.repository.TaxRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaxServiceImp implements TaxService{

    private final TaxRepository taxRepository;

    public TaxServiceImp(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }


    @Override
    public void insert(Tax tax) {taxRepository.insert(tax); }

    @Override
    public Tax get(String email) {
        return taxRepository.get(email);
    }
}
