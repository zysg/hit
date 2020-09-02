package com.htsc.dao;

import com.htsc.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<AccountUser> findAll();
}
