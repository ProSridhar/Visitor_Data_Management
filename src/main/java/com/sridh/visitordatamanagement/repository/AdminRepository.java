package com.sridh.visitordatamanagement.repository;

import com.sridh.visitordatamanagement.dto.Admin;

public interface AdminRepository {
	public String saveAdmin(Admin admin);
	public Admin adminLogin(String userName, String password);
}
