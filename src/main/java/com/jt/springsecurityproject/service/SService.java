package com.jt.springsecurityproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.springsecurityproject.model.User;
import com.jt.springsecurityproject.repository.Rep;

@Service
@Transactional
public class SService {
	@Autowired
    private Rep repositiory;
    public List<User> listAllUser() {
        return repositiory.findAll();
    }


public void saveUser(User user) {
	repositiory.save(user);
}

public User getUser(Integer id) {
return repositiory.findById(id).get();
}

public void deleteUser(Integer id) {
	repositiory.deleteById(id);
}
}
