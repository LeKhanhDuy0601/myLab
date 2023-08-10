package com.j6Lab5.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6Lab5.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{

}
