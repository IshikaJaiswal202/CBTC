package com.ishika.lms.service;

import java.util.List;

import com.ishika.lms.bean.Admin;
import com.ishika.lms.bean.Book;
import com.ishika.lms.bean.BookOperation;

import com.ishika.lms.bean.User;

public interface IAdminService {
	   public void saveAdmin(List<Admin> admins);
	   public boolean isAdminAvailable();
	   public boolean loginAdmin(String email,String password);
	   public void changeAdminStatus();
	   public  boolean isAdminByEmail(String email);

	   

	   public Integer saveUser(List<User> Users); 
	   public boolean updateUser(String email,String name,String contact,String address);
	   public boolean removeUser(String email);
	   public List<User> ListOFAllUser();
	   public void searchByUserName(String name);
	   public void statusChange(String email,String status);
	   public User showUserDetail(String email);
       public boolean isUserExists(String email);
       public boolean isUserActive(String email);
       
	  
       
	   public Integer saveBooks(List<Book>books);
	   public boolean deleteBook(String bookName);
	   public Book bookDetail(String bookName);
	   public boolean isBookExist(String bookName);
	   public List<Book> ListOfBooks();
	   public int bookQuantity(String bookName);
	   
	   public Integer saveIssuedBook(List<BookOperation> books);
	   public List<BookOperation> showAllIssuedBook();
	   public boolean searchByEmail(String email, String action);
	   public void returnBook(String Username,String returnDate,int fine,String Duration);
	   public boolean increaseBookQuantity(String name,int quantity,int toIncreaseBy);
	   public void decreaseBookQuantity(String name,int quantity);
	   
}
