package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Issue;
import utility.ConnectionManager;


public class Issuedao {
	final String insert_issue_query="insert into issue(book_id,user_id,issue_date)values(?,?,?)";
	final String Select_issue="select books.title, books.author,issue.issue_date,student.name from books inner join issue on books.book_id=issue.book_id inner join student on issue.user_id=student.user_id";
	
	List<Issue> issuelist=new ArrayList<Issue>();
	
	// method to insert data into issue record 
public void insertIssue(Issue issue) throws ClassNotFoundException, SQLException {
	PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(insert_issue_query);
	
	ps.setInt(1, issue.getIbooks_id());
	ps.setInt(2,issue.getIusers_id());
	ps.setString(3, issue.getIssue_date());
	
	ps.executeUpdate();
	
	System.out.println("book details Added successfully");
	
	
}


            // method showing record of issued book
public void getAllissueRecord() throws SQLException, ClassNotFoundException {

	PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(Select_issue);
	
	ResultSet rs =ps.executeQuery();
	System.out.println("BOOK_TITLE"+"\t"+"BOOK_AUTHOR"+"\t"+"ISSUE_DATE"+"\t"+"STUDENT_NAME");
 		while(rs.next()) {
 			
 			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDate(3)+"\t\t"+rs.getString(4))	;
 		}
}

   
}


