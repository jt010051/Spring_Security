package com.jt.springsecurityproject.security;

public enum Permission {
READ("student:read"),
WRITE("student_write");

		private final String permission;

	 Permission(String permission) {
	this.permission=permission;
	}

	public String getPermission() {
		return permission;
	}
}
