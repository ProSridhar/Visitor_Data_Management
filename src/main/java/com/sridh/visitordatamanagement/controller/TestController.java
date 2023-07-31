package com.sridh.visitordatamanagement.controller;

import com.sridh.visitordatamanagement.dto.Visitor;
import com.sridh.visitordatamanagement.repository.VisitorRepositoryImp;

public class TestController {
	public static void main(String[] args) {
		VisitorRepositoryImp vi = new VisitorRepositoryImp();
		System.out.println(vi.saveVisitor(new Visitor("Surya", "surya@gmail.com", "981521245")));
		System.out.println(vi.saveVisitor(new Visitor("Harshvardhan", "harsh@gmail.com", "755212453")));
		System.out.println(vi.saveVisitor(new Visitor("Himanshu", "himanshu@gmail.com", "986524545")));
		System.out.println(vi.saveVisitor(new Visitor("Zigma", "zigma@gmail.com", "1980024545")));
		System.out.println(vi.saveVisitor(new Visitor("Nisha", "nisha@gmail.com", "965212453")));

		System.out.println(vi.getAllVisitors());

		Visitor tU = new Visitor();
		System.out.println(vi.UpdateVisitor(tU));

		System.out.println(vi.getVisitorById(2));
		System.out.println(vi.getVisitorByEmail("surya@gmail.com"));
		System.out.println(vi.getVisitorByPhone("1980024545"));

		System.out.println(vi.deleteRepositoryById(5));
	}
}
