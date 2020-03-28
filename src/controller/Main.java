package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import dao.Issuedao;
import dao.LibarianDAO;
import model.Book;
import model.Issue;
import model.Students;
import utility.ConnectionManager;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("\t<<<<<<<...........E-library...........>>>>>>>");
          //	detail to enter as librarian
	System.out.println(">>>> Login as Librarian to Maintain record of E-library ");
	System.out.println("enter your details to get access");
	System.out.println("enter your Registered Name :");
	String Librarian_name=br.readLine();
	System.out.println("enter your Password :");
	String password=br.readLine();
	System.out.println("Confirm your Password :");
	String cpassword=br.readLine();
	boolean result=false;
	// validating entered detail
	if(Librarian_name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin") && cpassword.equalsIgnoreCase("admin")) {
		System.out.println("Your Access is granted !!!! ");
		result=true;
	}
	else {
		System.out.println("Entered Detail is wrong...please check again..... ");
		
		result=true;
		
	}
	if(result==true) {
	do {
	ConnectionManager.getConnection();
	System.out.println("what you want to do...");
	System.out.println("\t"+"1.Create new Student record");
	System.out.println("\t"+"2.View Student record");
	System.out.println("\t"+"3.Update Student record");
	System.out.println("\t"+"4.Delete Student Record");
	System.out.println("\t"+"5.show all book Record");
	System.out.println("\t"+"6.Delete book");
	System.out.println("\t"+"7.insert book");
	System.out.println("\t"+"8.modify book");
	System.out.println("\t"+"9.Create record of issued book to student");
	System.out.println("\t"+"10.view issue record");
	int choice =Integer.parseInt(br.readLine());
	//creating object
	Students student=new Students();
	LibarianDAO librariandao=new LibarianDAO();
	BookDAO bookdao=new BookDAO();
	Book book =new Book();
	Issue issue=new Issue();
	Issuedao issuedao=new Issuedao();

	switch(choice) {
	case 1:
		//creating book record
		
		System.out.println("create student record");
		System.out.println("enter user id :");
		int userid=Integer.parseInt(br.readLine());
		System.out.println("enter Student name:");
		String name=br.readLine();
		System.out.println("enter Student address:");
		String address=br.readLine();
		System.out.println("enter Student mobile:");
		int mobile=Integer.parseInt(br.readLine());
		
		LocalDate joinDate=LocalDate.now();
		student.setUserId(userid);
		student.setName(name);
		student.setAddress(address);
		student.setMobile(mobile);
		student.setJoinDate(joinDate);
		librariandao.insertstudent(student);
	
		break;
		
	case 2:
		//view data of student
		System.out.println("view all data of existing students");
		librariandao.getAllstudents();

		break;
	case 3:
		//  update record of student
		
		System.out.println("modify records of student");
		System.out.println("enter ID of record which you want modify : ");
   
		int user_id=Integer.parseInt(br.readLine());
		if(librariandao.checkid(user_id)) {
		student.setUserId(user_id);
		System.out.println("update name :");
		String u_name=br.readLine();
		System.out.println("Update address :");
		String u_address=br.readLine();
		System.out.println("Update mobile :");
		int u_mobile=Integer.parseInt(br.readLine());
		
		LocalDate u_joinDate=LocalDate.now();
		
        student.setUserId(user_id);
		student.setName(u_name);
		student.setAddress(u_address);
		student.setMobile(u_mobile);
		student.setJoinDate(u_joinDate);
		
		librariandao.ModifyStudent(student);
		}
	
		else
		{
			System.out.println("Entered id doesn't exist");
		}
		break;
	case  4:
		//delete record of student
		System.out.println("Enter id Which you want to delete");
		
		int u_id=Integer.parseInt(br.readLine());
		
		librariandao.deleteStudent(u_id);
		
		
		break;
	case 5:
		// view record of books
		System.out.println("view record of books");
		bookdao.getAllBooks();
		break;
		
	case 6:
		// delete  book record
		System.out.println("delete book record");
		int book_id=Integer.parseInt(br.readLine());
		
	     bookdao.delete(book_id);
		
		
		break;
	case 7:
		//add new book in library
		System.out.println("insert new book record ");
		System.out.println("enter book id :");
		int bookid=Integer.parseInt(br.readLine());
		System.out.println("enter author :");
		String author=br.readLine();
		System.out.println("enter title:");
		String title=br.readLine();
		System.out.println("enter  isbn:");
		int isbn=Integer.parseInt(br.readLine());
	    book.setBookid(bookid);
		book.setAuthor(author);
		book.setTitle(title);
		book.setIsbn(isbn);
		bookdao.insertBook(book);
	    break;
	case 8:
		// update library
		System.out.println("modify record of books");
		System.out.println("enter ID of record which you want modify : ");
		int b_id=Integer.parseInt(br.readLine());
		System.out.println("update Author :");
		String b_author=br.readLine();
		System.out.println("Update Title :");
		String b_title=br.readLine();
		System.out.println("Update isbn :");
		int b_isbn=Integer.parseInt(br.readLine());
		book.setBookid(b_id);
		book.setAuthor(b_author);
		book.setTitle(b_title);
		book.setIsbn(b_isbn);
        bookdao.Modifybook(book);
	case 9:
		// insert into issue record
		System.out.println("insert issued record");
		System.out.println("enter book_id :");
		int Ibook_id=Integer.parseInt(br.readLine());
		System.out.println("enter user_id :");
		int Iuser_id=Integer.parseInt(br.readLine());
		System.out.println("enter issue_date :");
		String issue_date=br.readLine();
		issue.setIbooks_id(Ibook_id);
		issue.setIusers_id(Iuser_id);
		issue.setIssue_date(issue_date);
		issuedao.insertIssue(issue);
	case 10:
		// show issued books record
		System.out.println("show issue record");
		issuedao.getAllissueRecord();
		
		
		
	
	}
	

	}while(result==true);
	
}}
}