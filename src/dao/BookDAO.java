package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Students;
import utility.ConnectionManager;
import model.Book;

public class BookDAO {
	final String insert_book_query="insert into books(book_id,author,title,isbn)values(?,?,?,?)";
	private static final String Modify_books="update books set author=?,title=?,isbn=? where book_id=?";
        // final String Select_books="select * from books";
         
	List<Book> booklist=new ArrayList<Book>();

	public void insertBook(Book book) throws ClassNotFoundException, SQLException, IOException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(insert_book_query);

		ps.setInt(1,book.getBookid());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getTitle());
		ps.setInt(4, book.getIsbn());
		
		ps.executeUpdate();
		
		System.out.println("book details Added successfully");
	}
	public void getAllBooks() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery("select * from books");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));

		

		}

		
	}
	public void Modifybook(Book book) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(Modify_books);
	
		
		ps.setString(1, book.getAuthor());
		ps.setString(2,book.getTitle() );
		ps.setInt(3,book.getIsbn());
		
		ps.setInt(4, book.getBookid());
		
		boolean rowUpdated=ps.executeUpdate()>0;
		if(rowUpdated) {
			System.out.println("record updated successfully");
		}
		else {
				System.out.println("check again");
		}
		
	}
	public void delete(int book_id) throws ClassNotFoundException, SQLException{

		Boolean rowDeleted;
			Connection con=ConnectionManager.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from books where book_id=?");
			ps.setInt(1, book_id);
			
			rowDeleted=ps.executeUpdate()>0;
			   if(rowDeleted) {
				   System.out.println("record deleted");
				}
				else {
						System.out.println("no blog with that id");
				}
		}
	
	
}
