package com.jt.springsecurityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jt.springsecurityproject.model.User;

@Repository("SQL")
public interface Rep extends JpaRepository<User, Integer> {

}
