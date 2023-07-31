package com.sridh.visitordatamanagement.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Visitor {
	private static int id;
	private String name;
	private String email;
	LocalDate visitedDate = LocalDate.now();
//	private Date visitedDate;
	private String phone;
	private int temp=this.getId();
	
//	static{id=1;}
	{this.id=++id;}
	
	public Visitor() {}
	@Override
	public String toString() {
		return "Visitor [id=" + ++temp + ", name=" + name + ", email=" + email + ", visitedDate=" + visitedDate + ", phone="
				+ phone + "]";
	}

	public Visitor(String name,String email,String phone) {
		this.name = name;
		this.email=email;
		this.phone=phone;		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getVisitedDate() {
		return visitedDate;
	}
	public void setVisitedDate(LocalDate visitedDate) {
        this.visitedDate = visitedDate;
    }
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
		
		
	}

