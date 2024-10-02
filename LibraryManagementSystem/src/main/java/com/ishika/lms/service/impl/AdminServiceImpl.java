package com.ishika.lms.service.impl;

import java.util.List;

import com.ishika.lms.bean.Admin;
import com.ishika.lms.bean.Book;
import com.ishika.lms.bean.BookOperation;

import com.ishika.lms.bean.User;
import com.ishika.lms.dao.IAdminDao;
import com.ishika.lms.dao.IBookDao;

import com.ishika.lms.dao.IUserDao;
import com.ishika.lms.dao.impl.AdminDaoImpl;
import com.ishika.lms.dao.impl.BookDaoImpl;
import com.ishika.lms.dao.impl.UserDaoImpl;
import com.ishika.lms.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	 private IAdminDao adminDao=null;
	 private IUserDao UserDao=null;
	 private IBookDao bookDao=null;
		public AdminServiceImpl() {
			super();
			adminDao=new AdminDaoImpl();
			UserDao=new UserDaoImpl();
			bookDao= new BookDaoImpl();
		}
		@Override
		public void saveAdmin(List<Admin> admins) {
		     adminDao.insertAdmin(admins);
		}

		@Override
		public boolean isAdminAvailable() {
			boolean status =adminDao.isAdminExists();
			return status;
		}

		@Override
		public boolean loginAdmin(String email,String password) 
		{
			boolean islog=adminDao.login(email, password);
			return islog;
		}

		@Override
		public void changeAdminStatus() {
			adminDao.changeAdminStatus(null, null);
		}
		
		@Override
		public boolean removeUser(String email) {
			boolean is=UserDao.remove_User(email);
			return is;
		}
		@Override
		public List<User> ListOFAllUser() {
			return UserDao.ListOFAll_User();
			
		}
		@Override
		public void searchByUserName(String name) {
			UserDao.searchByName_User(name);
			
		}
		@Override
		public void statusChange(String email, String status) {
			UserDao.changeStatus(email, status);
			
		}
		@Override
		public User showUserDetail(String email) {
			return UserDao.showDetailByEmail(email);			
		}
		@Override
		public Integer saveUser(List<User> Users) {
				int count=UserDao.insertUser(Users);
				return count;
			}
		@Override
		public Integer saveBooks(List<Book> books) {
			 int size=bookDao.insertBooks(books);
			return size;
		}
		@Override
		public boolean deleteBook(String bookName) {
			boolean is=bookDao.deleteBook(bookName);
			return is;
		}
		
		@Override
		public Book bookDetail (String bookName) {
			return bookDao.bookDetail(bookName);
		}
		@Override
		public boolean isBookExist(String bookName) 
		{
			boolean is=bookDao.isBookExist(bookName);
			return is;
		}
		@Override
		public List<Book> ListOfBooks() 
		{
			return bookDao.ListOfBooks();
		}
		@Override
		public int bookQuantity(String bookName) 
		{
			int quan=bookDao.bookQuantity(bookName);
			return quan;
		}
		@Override
		public Integer saveIssuedBook(List<BookOperation> books) {
			int val=bookDao.insertIssuedBook(books);
			return val;
		}
		@Override
		public List<BookOperation> showAllIssuedBook() {
			return bookDao.showAllIssuedBook();
			
		}
		@Override
		public void returnBook(String Username, String returnDate, int fine, String Duration) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean increaseBookQuantity(String name, int quantity, int toIncreaseBy) {
			return bookDao.increaseBookQuantity(name, quantity, toIncreaseBy);			
			
		}
		@Override
		public void decreaseBookQuantity(String name, int quantity) {
			  bookDao.decreaseBookQuantity(name, quantity);
		}
		@Override
		public boolean isUserExists(String email) {
			return UserDao.isUserExixts(email);
			
		}
		@Override
		public boolean isAdminByEmail(String email) {
			return adminDao.isAdminByEmail(email);
			
		}
	    @Override
		public boolean isUserActive(String email) {
		    return UserDao.isUserActive(email);
		}
		@Override
		public boolean updateUser(String email,String name,String contact,String address) {
	        return UserDao.updateUser(email, name, contact, address);
	     }
		
		@Override
		public boolean searchByEmail(String email, String action) {
			return bookDao.searchByEmail(email, action);
		}
}
