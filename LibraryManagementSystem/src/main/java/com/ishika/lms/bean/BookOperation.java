package com.ishika.lms.bean;

public class BookOperation 
{
	private String issuedBookId=null;
	private String issuedBookName=null;
	private String authoreName=null;
	private String userName=null;
	private String userEmail=null;
	private String issuedDate=null;
	private int fine=0;
	private String returnDate=null;
	private String Duration=null;
	private String issuedTo=null;
	public BookOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookOperation(String issuedBookId, String issuedBookName, String authoreName, String userName,
			String userEmail, String issuedDate, String returnDate, int fine, String duration, String issuedTo) {
		super();
		this.issuedBookId = issuedBookId;
		this.issuedBookName = issuedBookName;
		this.authoreName = authoreName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.issuedDate = issuedDate;
		this.fine = fine;
		this.returnDate = returnDate;
		Duration = duration;
		this.issuedTo = issuedTo;
	}

	public String getIssuedBookId() {
		return issuedBookId;
	}
	public void setIssuedBookId(String issuedBookId) {
		this.issuedBookId = issuedBookId;
	}
	public String getIssuedBookName() {
		return issuedBookName;
	}
	public void setIssuedBookName(String issuedBookName) {
		this.issuedBookName = issuedBookName;
	}
	public String getAuthoreName() {
		return authoreName;
	}
	public void setAuthoreName(String authoreName) {
		this.authoreName = authoreName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	public String getIssuedTo() {
		return issuedTo;
	}
	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}
	@Override
	public String toString() {
		return "BookOperation [issuedBookId=" + issuedBookId + ", issuedBookName=" + issuedBookName + ", authoreName="
				+ authoreName + ", userName=" + userName + ", userEmail=" + userEmail + ", issuedDate=" + issuedDate
				+ ", fine=" + fine + ", returnDate=" + returnDate + ", Duration=" + Duration + ", issuedTo=" + issuedTo
				+ "]";
	}
	
				
}
