package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Students;
import utility.ConnectionManager;

public class LibarianDAO {
   
	List<Students> studentlist=new ArrayList<Students>();
	
	final String insert_student_query="insert into Student(user_id,name,address,mobile,joining_date)values(?,?,?,?,?)";
	final String Select_student="select * from student";
	private static final String Modify_student="update student set name=?,address=?,mobile=?, joining_date=? where user_id=?";
	private static final String delete_student="delete from student where user_id=?";
	
	public void insertstudent(Students student) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(insert_student_query);
		ps.setLong(1,student.getUserId());
		ps.setString(2, student.getName());
		ps.setString(3, student.getAddress() );
		ps.setInt(4, student.getMobile());
		ps.setDate(5, java.sql.Date.valueOf(student.getJoinDate()));
		ps.executeUpdate();
	}
	
	public void getAllstudents() throws ClassNotFoundException, SQLException {
		Students student=new Students();
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery(Select_student);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t");

		

		}
		

		
	}
	public void ModifyStudent(Students student) throws ClassNotFoundException, SQLException {
		boolean status=false;
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(Modify_student);
        ps.setString(1, student.getName());
		ps.setString(2, student.getAddress() );
		ps.setInt(3, student.getMobile());
		ps.setDate(4, java.sql.Date.valueOf(student.getJoinDate()));
		ps.setInt(5, student.getUserId());
		
		boolean rowUpdated=ps.executeUpdate()>0;
		if(rowUpdated) {
			System.out.println("record updated successfully");
		}
		else {
				System.out.println("check again");
		}
		
	}
	
	public void deleteStudent(int user_id) throws ClassNotFoundException, SQLException {
		Boolean rowDeleted;
		Connection connection=ConnectionManager.getConnection();
	   PreparedStatement statement=connection.prepareStatement(delete_student);
	   statement.setInt(1, user_id);
	   rowDeleted=statement.executeUpdate()>0;
	   if(rowDeleted) {
		   System.out.println("record deleted");
		}
		else {
				System.out.println("no blog with that id");
		}
	   
	}

	public boolean checkid(int user_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		
		Statement st = ConnectionManager.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery(Select_student);
		
		while(rs.next()) {
			if(rs.getInt(1)==user_id) {
				result = true;
			}
		}
		return result;
		
		
	}
	
	
	}
