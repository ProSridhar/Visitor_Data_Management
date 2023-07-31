package com.sridh.visitordatamanagement.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sridh.visitordatamanagement.dto.Visitor;
import com.sridh.visitordatamanagement.util.AppConstants;
import com.sridh.visitordatamanagement.util.ConnectionUtil;

public class VisitorRepositoryImp implements VisitorRepository {

	@Override
	public String saveVisitor(Visitor visitor) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "Insert into visitors(vid, vname, vemail, visited_date, vphone) Values(?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, visitor.getId());
			ps.setString(2, visitor.getName());
			ps.setString(3, visitor.getEmail());
			ps.setObject(4, visitor.getVisitedDate());
			ps.setString(5, visitor.getPhone());
			int res = ps.executeUpdate();
			connection.close();
			return AppConstants.SUCCESS_MESSAGE;
		} catch (SQLException e) {
			e.printStackTrace();
			return AppConstants.ERROR_MESSAGE;
		}

	}

	@Override
	public String UpdateVisitor(Visitor visitor) {
		Visitor tempVisitor=new Visitor();
		Scanner os = new Scanner(System.in);
		System.out.println("Enter your ID to proceed");
		int idv = os.nextInt();
		
		Connection connection = ConnectionUtil.getConnection();
		String sql2 = "Select * from visitors";
		try {
			PreparedStatement ps = connection.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery(sql2);
			
			if(rs.isBeforeFirst()) {
				while(rs.next() && tempVisitor.getId()<=visitor.getId()) {
					tempVisitor.setId(visitor.getId());
					tempVisitor.setName(visitor.getName());
					tempVisitor.setPhone(visitor.getPhone());
					tempVisitor.setVisitedDate(visitor.getVisitedDate());
					tempVisitor.setEmail(visitor.getEmail());
				}
			}
					System.out.println("Enter number 1-3 \n1.Update Name \n2.Update Email \n3.Update Phone");
					int n = os.nextInt();
					String sqlName = "UPDATE visitors"+" SET vname =? WHERE"+" vid = ?";
					String sqlEmail = "UPDATE visitors"+" SET vemail =? WHERE"+" vid = ?";
					String sqlPhone = "UPDATE visitors"+" SET vphone =? WHERE"+" vid = ?";
					PreparedStatement ps1 = connection.prepareStatement(sqlName);
					PreparedStatement ps2 = connection.prepareStatement(sqlEmail);
					PreparedStatement ps3 = connection.prepareStatement(sqlPhone);
					switch(n){
					case 1:
						int rs1=0;
						if(tempVisitor.getId()==visitor.getId()) {
							System.out.println("Enter the new Name to be updated");
							String NEW_NAME=os.next();
	//						ps1.setString(1, "vname");
							ps1.setString(1, NEW_NAME);
							ps1.setInt(2, idv);
							rs1 = ps1.executeUpdate();
						}
						if(rs1!=0) return AppConstants.SUCCESS_MESSAGE;
						else return AppConstants.UNIDENTIFIED_MESSAGE;
					case 2:
						int rs2=0;
						if(tempVisitor.getId()==visitor.getId()) {
							System.out.println("Enter the new Email to be updated");
							String NEW_EMAIL=os.next();
	//						ps1.setString(1, "vemail");
							ps2.setString(1, NEW_EMAIL);
							ps2.setInt(2, idv);
							rs2 = ps2.executeUpdate();
						}
						if(rs2!=0) return AppConstants.SUCCESS_MESSAGE;
						else return AppConstants.UNIDENTIFIED_MESSAGE;
					case 3:
						int rs3=0;
						if(tempVisitor.getId()==visitor.getId()) {
							System.out.println("Enter the new Phone Number to be updated");
							String NEW_PHONE=os.next();
	//						ps1.setString(1, "vphone");
							ps3.setString(1, NEW_PHONE);
							ps3.setInt(2, idv);
							rs3 = ps3.executeUpdate();
						}
						if(rs3!=0) return AppConstants.SUCCESS_MESSAGE;
						else return AppConstants.UNIDENTIFIED_MESSAGE;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "as";
	}

	@Override
	public Visitor getVisitorById(int id) {
		Connection connection = ConnectionUtil.getConnection();
		Visitor visitor = new Visitor();
		String sql = "SELECT * FROM visitors WHERE vid =?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Visitor visitor2 = new Visitor();
					visitor2.setId(rs.getInt("vid"));
					visitor2.setName(rs.getString("vname"));
					visitor2.setPhone(rs.getString("vphone"));
					visitor2.setVisitedDate(rs.getDate("visited_date").toLocalDate());
					visitor2.setEmail(rs.getString("vemail"));
					visitor = visitor2;
					if (id == visitor.getId()) {
						return visitor;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitor;
	}

	@Override
	public Visitor getVisitorByPhone(String phone) {
		Connection connection = ConnectionUtil.getConnection();
		Visitor visitor = new Visitor();
		String sql = "SELECT * FROM visitors WHERE vphone =?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Visitor visitor2 = new Visitor();
					visitor2.setId(rs.getInt("vid"));
					visitor2.setName(rs.getString("vname"));
					visitor2.setPhone(rs.getString("vphone"));
					visitor2.setVisitedDate(rs.getDate("visited_date").toLocalDate());
					visitor2.setEmail(rs.getString("vemail"));
					visitor = visitor2;
					if (phone.equals(visitor.getPhone())) {
						return visitor;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitor;
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		Connection connection = ConnectionUtil.getConnection();
		Visitor visitor = new Visitor();
		String sql = "SELECT * FROM visitors WHERE vemail =?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					Visitor visitor2 = new Visitor();
					visitor2.setId(rs.getInt("vid"));
					visitor2.setName(rs.getString("vname"));
					visitor2.setPhone(rs.getString("vphone"));
					visitor2.setVisitedDate(rs.getDate("visited_date").toLocalDate());
					visitor2.setEmail(rs.getString("vemail"));
					visitor = visitor2;
					if (email.equals(visitor.getEmail())) {
						return visitor;
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return visitor;
	}

	@Override
	public List<Visitor> getAllVisitors() {
		Connection connection = ConnectionUtil.getConnection();
		List<Visitor> list = null;
		String sql = "Select * from visitors";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<>();
				while (rs.next()) {
					Visitor visitor = new Visitor();
					visitor.setId(rs.getInt("vid"));
					visitor.setName(rs.getString("vname"));
					visitor.setEmail(rs.getString("vemail"));
					visitor.setPhone(rs.getString("vphone"));
					visitor.setVisitedDate(rs.getDate("visited_date").toLocalDate());
					list.add(visitor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Visitor> getVisitorsByVisitingDate(Date date) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "Select * from visitors where visited_date =?";
		List<Visitor> list = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {
				list = new ArrayList<>();
				while (rs.next()) {
					Visitor visitor2 = new Visitor();
					visitor2.setId(rs.getInt("vid"));
					visitor2.setName(rs.getString("vname"));
					visitor2.setPhone(rs.getString("vphone"));
					visitor2.setVisitedDate(rs.getDate("visited_date").toLocalDate());
					visitor2.setEmail(rs.getString("vemail"));
					if (date.equals(visitor2.getVisitedDate()))
						list.add(visitor2);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteRepositoryById(int id) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "Delete from visitors where vid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			if(rs==1) return AppConstants.SUCCESS_MESSAGE;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AppConstants.ERROR_MESSAGE;
	}
		
		
	public static void main(String[] args) {

	}

}
