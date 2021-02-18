package com.jt.springsecurityproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.springsecurityproject.model.User;


public interface Rep extends JpaRepository<User, Integer> {

}
