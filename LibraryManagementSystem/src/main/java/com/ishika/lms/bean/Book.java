package com.ishika.lms.bean;

public class Book {
   private String bookId=null;
   private String bookName=null;
   private String authoreName=null;
   private int noOfPages=0;
   private String bookSubject=null;
   private int bookQuantity=0;
   private String createdDate=null;
   public Book()
   {
	super();
   }
   public Book(String bookId, String bookName, String authoreName, int noOfPages, String bookSubject, int bookQuantity,
		String createdDate) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.authoreName = authoreName;
	this.noOfPages = noOfPages;
	this.bookSubject = bookSubject;
	this.bookQuantity = bookQuantity;
	this.createdDate = createdDate;
   }
   public Book( String bookName, String authoreName, int noOfPages, String bookSubject, int bookQuantity) {
		super();
		this.bookName = bookName;
		this.authoreName = authoreName;
		this.noOfPages = noOfPages;
		this.bookSubject = bookSubject;
		this.bookQuantity = bookQuantity;
	   }
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthoreName() {
	return authoreName;
}
public void setAuthoreName(String authoreName) {
	this.authoreName = authoreName;
}
public int getNoOfPages() {
	return noOfPages;
}
public void setNoOfPages(int noOfPages) {
	this.noOfPages = noOfPages;
}
public String getBookSubject() {
	return bookSubject;
}
public void setBookSubject(String bookSubject) {
	this.bookSubject = bookSubject;
}
public int getBookQuantity() {
	return bookQuantity;
}
public void setBookQuantity(int bookQuantity) {
	this.bookQuantity = bookQuantity;
}
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authoreName=" + authoreName + ", noOfPages="
			+ noOfPages + ", bookSubject=" + bookSubject + ", bookQuantity=" + bookQuantity + ", createdDate="
			+ createdDate + "]";
}
   

   
   
   
   
}
