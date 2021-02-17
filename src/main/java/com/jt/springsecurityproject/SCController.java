package com.jt.springsecurityproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springsecurityproject.model.User;


@RestController
@RequestMapping("project/user")
public class SCController {
	private static final List<User> USERS= Arrays.asList(
			new User (1, "James Bond", "j@gmail.com", "jbond", "password", "STANDARD"),
			new User(2, "Mariah Hill", "m@gmail.com", "mhill", "password", "STANDARD"),
			new User(3, "Steph Curry", "s@gmail.com", "scurry", "password", "STANDARD")

			);
	@GetMapping(path = "{id}")
public User getUser(@PathVariable ("id") Integer userId) {
	return USERS.stream()
			.filter(user -> userId.equals(user.getId()))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("Student " + userId +" does not exist"));
	
}
}
