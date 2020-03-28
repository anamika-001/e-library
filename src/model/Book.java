package model;
//getter setter for book table
public class Book {
	
	private int bookid;
	private String author;
	private String title;
	private int isbn;
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public Book(int bookid, String title, String author, int isbn) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	

}
