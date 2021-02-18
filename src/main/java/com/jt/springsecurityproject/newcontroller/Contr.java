package com.jt.springsecurityproject.newcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jt.springsecurityproject.model.User;
import com.jt.springsecurityproject.service.SService;

@RestController
@RequestMapping("/")
public class Contr {
	 @Autowired
	    SService service;
	@GetMapping("login")
public ModelAndView getLoginView() {
	
	return  new ModelAndView("login.html");
}
  @GetMapping("/getall")
public List<User> getAllUsers(){
  	
      return service.listAllUser();
  }
}