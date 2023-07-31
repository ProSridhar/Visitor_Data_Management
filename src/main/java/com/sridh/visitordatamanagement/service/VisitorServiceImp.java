package com.sridh.visitordatamanagement.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sridh.visitordatamanagement.dto.Visitor;
import com.sridh.visitordatamanagement.repository.VisitorRepository;
import com.sridh.visitordatamanagement.repository.VisitorRepositoryImp;
import com.sridh.visitordatamanagement.util.AppConstants;
import com.sridh.visitordatamanagement.util.ConnectionUtil;

public class VisitorServiceImp implements VisitorService{

	private VisitorRepository repository = new VisitorRepositoryImp();

	@Override
	public String saveVisitor(Visitor visitor) {
		return repository.saveVisitor(visitor);
		
	}

	@Override
	public String UpdateVisitor(Visitor visitor) {
		return null;
	}

	@Override
	public Visitor getVisitorById(int id) {
		return repository.getVisitorById(id);
	}

	@Override
	public Visitor getVisitorByPhone(String phone) {
		return repository.getVisitorByPhone(phone);
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		return repository.getVisitorByEmail(email);
	}

	@Override
	public List<Visitor> getAllVisitors() {
		return repository.getAllVisitors();
		
	}

	@Override
	public List<Visitor> getVisitorsByVisitingDate(Date date) {
		return repository.getVisitorsByVisitingDate(date);
	}

	@Override
	public String deleteRepositoryById(int id) {
		return null;
	}

}
