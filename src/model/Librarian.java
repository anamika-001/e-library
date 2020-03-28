package model;

public class Librarian {
	private int id;
	private String position;
	private int mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public Librarian(int id, String position, int mobile) {
		super();
		this.id = id;
		this.position = position;
		this.mobile = mobile;
	}
	
	

}
