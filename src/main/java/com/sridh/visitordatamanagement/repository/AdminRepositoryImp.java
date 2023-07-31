package com.sridh.visitordatamanagement.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sridh.visitordatamanagement.dto.Admin;
import com.sridh.visitordatamanagement.util.AppConstants;
import com.sridh.visitordatamanagement.util.ConnectionUtil;

public class AdminRepositoryImp implements AdminRepository {

	@Override
	public String saveAdmin(Admin admin) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "Insert into admin values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			int res = ps.executeUpdate();
			connection.close();
			return AppConstants.SUCCESS_MESSAGE;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AppConstants.ERROR_MESSAGE;
	}

	@Override
	public Admin adminLogin(String userName, String password) {
		Admin a = new Admin();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "select * from admin where admin_username=? AND admin_password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next() ) { // work on this line
					
					a.setUsername(userName);
					a.setPassword(password);
					return a;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
