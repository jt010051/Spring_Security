package com.jt.springsecurityproject;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.jt.springsecurityproject.model.User;
import com.jt.springsecurityproject.service.SService;


@RestController
@RequestMapping("project/user")

public class SCController {

	Logger logger = LoggerFactory.getLogger(SpringSecurityProjectApplication.class);

	    @Autowired
	    SService service;
    
    
    @GetMapping("/getall")
public List<User> getAllUsers(){
    	
        return service.listAllUser();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@RequestParam("User-id") Integer id) {
        try {
            User user = service.getUser(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public void add(@RequestBody User user) {
		logger.info(user.toString());

    	service.saveUser(user);
    }
}
