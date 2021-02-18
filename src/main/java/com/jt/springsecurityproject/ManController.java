package com.jt.springsecurityproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.springsecurityproject.model.User;
import static com.jt.springsecurityproject.security.Role.*;
@RestController
@RequestMapping("project/manage/users")
public class ManController {
	private static final List<User> USERS= Arrays.asList(
			new User (1, "James Bond"),
			new User(2, "Maria Jones"),
			new User(3, "Anna Smith")

			);
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public List<User> getAllStudents(){
		System.out.println("getAllUsers");
		return USERS;
	}
	@PostMapping
	@PreAuthorize("hasAuthority('student_read')")

	public void registerNewStudent(@RequestBody User user) {
		System.out.println("registerNewStudent");
		System.out.println(user);
	}
	@DeleteMapping(path = "{id}")
	@PreAuthorize("hasAuthority('student_read')")
	public void deleteStudent(@PathVariable("id") Integer userId) {
		System.out.println("deleteStudent");

		System.out.println(userId);
	}
	@PutMapping(path = "{studentId}")
	@PreAuthorize("hasAuthority('student_read')")
	public void updateStudent(@PathVariable("studentId")Integer userId, @RequestBody User user) {
		System.out.println("updateStudent");
		System.out.println(String.format("%s %s", userId, user));
	}
}
