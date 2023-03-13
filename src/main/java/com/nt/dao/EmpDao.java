package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.entity.Employee;

public class EmpDao {
	
	public Employee selectDao(int id) {
		Employee emp = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_test",
					"root", 
					"3nt3r_MYSQL");
			PreparedStatement ps = con.prepareStatement("select * from tb_employee where id=?");
			ps.setInt(1, id);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			

			if(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSal(rs.getInt("salary"));
			}
			
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public void register(int id, String name, int sal) {
		// Add to db
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/db_test",
							"root", 
							"3nt3r_MYSQL");
					PreparedStatement ps = con.prepareStatement("insert into tb_employee values (?,?,?)");
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setInt(3, sal);
					ps.executeUpdate();
					
					con.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
	}
	public void update(int sal, String name) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test","root","3nt3r_MYSQL");
			
			PreparedStatement ps = con.prepareStatement("Update tb_employee set salary = ? where name = ?");
			ps.setInt(1, sal);
			ps.setString(2, name);
			
			ps.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
