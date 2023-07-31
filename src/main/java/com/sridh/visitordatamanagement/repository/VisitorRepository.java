package com.sridh.visitordatamanagement.repository;

import java.sql.Date;
import java.util.List;

import com.sridh.visitordatamanagement.dto.Visitor;

public interface VisitorRepository {
	public String saveVisitor(Visitor visitor);
	public String UpdateVisitor(Visitor visitor);
	public Visitor getVisitorById(int id);
	public Visitor getVisitorByPhone(String phone);
	public Visitor getVisitorByEmail(String email);
	public List<Visitor> getAllVisitors();
	public List<Visitor> getVisitorsByVisitingDate(Date date);
	public String deleteRepositoryById(int id);
	
}
