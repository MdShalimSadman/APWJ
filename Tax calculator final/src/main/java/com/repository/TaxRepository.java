package com.repository;

import com.domain.Tax;
import com.domain.User;

public interface TaxRepository {

    public void insert(Tax tax);

    public Tax get(int id);
}
