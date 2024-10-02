package com.ishika.lms.dao;

import java.util.List;

import com.ishika.lms.bean.Book;
import com.ishika.lms.bean.BookOperation;

public interface IBookDao 
{
  public Integer insertBooks(List<Book>books);
  public boolean deleteBook(String bookName);
  public Book bookDetail(String bookName);
  public boolean isBookExist(String bookName);
  public List<Book> ListOfBooks();
  public int bookQuantity(String bookName);
  public boolean checkUserForIssued(); 
  
  public Integer insertIssuedBook(List<BookOperation> books);
  public List<BookOperation> showAllIssuedBook();
  public boolean searchByEmail(String email,String action);
  public void returnBook(String Username,String returnDate,int fine,String Duration);
  public boolean increaseBookQuantity(String name,int quantity,int toIncreaseBy);
  public void decreaseBookQuantity(String name,int quantity);
  
}
