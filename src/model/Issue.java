package model;
// getter setter for issue table
public class Issue {
	private int Ibooks_id;
	private int Iusers_id;
	private String Issue_date;
	public int getIbooks_id() {
		return Ibooks_id;
	}
	public void setIbooks_id(int ibooks_id) {
		Ibooks_id = ibooks_id;
	}
	public int getIusers_id() {
		return Iusers_id;
	}
	public void setIusers_id(int iusers_id) {
		Iusers_id = iusers_id;
	}
	public String getIssue_date() {
		return Issue_date;
	}
	public void setIssue_date(String issue_date) {
		Issue_date = issue_date;
	}
	public Issue(int ibooks_id, int iusers_id, String issue_date) {
		super();
		Ibooks_id = ibooks_id;
		Iusers_id = iusers_id;
		Issue_date = issue_date;
	}
	public Issue() {
		// TODO Auto-generated constructor stub
	}
	
	

}
