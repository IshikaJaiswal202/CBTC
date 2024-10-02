package com.ishika.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ishika.lms.Validation;
import com.ishika.lms.bean.Book;
import com.ishika.lms.bean.BookOperation;
import com.ishika.lms.dao.IBookDao;
import com.ishika.lms.util.DBCon;

public class BookDaoImpl implements IBookDao {
	Scanner sc=new Scanner(System.in);
    Connection con=null;
    String DB_QUERY=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public BookDaoImpl() 
    {
    	super();
    	try {
			con=DBCon.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Integer insertBooks(List<Book> books) {
	    DB_QUERY="Insert into BOOKS values(?,?,?,?,?,?,?)";
	    int count[] = null;
	    try 
	    {
		    ps=con.prepareStatement(DB_QUERY);
	     for(Book book:books)
	    {
	    ps.setString(1, UUID.randomUUID().toString());
		ps.setString(2, book.getBookName());
		ps.setString(3, book.getAuthoreName());
		ps.setInt(4, book.getNoOfPages());
		ps.setString(5, book.getBookSubject());
		ps.setInt(6, book.getBookQuantity());
		ps.setString(7, book.getCreatedDate());
		ps.addBatch();
	    }
		  count=ps.executeBatch();

	   }
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return count.length;
	}

	@Override
	public boolean deleteBook(String bookName) {
		DB_QUERY="Delete from Books where Book_Name=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, bookName);
		    boolean count=ps.executeUpdate()>0;
		    if(count)
		    {
		    	return true;
		    }
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	
	}


	
	@Override
	public Book bookDetail(String bookName) 
	{
		Book books=null;
		DB_QUERY="Select * from Books where Book_Name=?";
		try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, bookName);
			rs=ps.executeQuery();
			if(rs.next())
			{
				books=new Book
						(
						 rs.getString("book_Name"),
				         rs.getString("authore_Name"),
				         rs.getInt("No_Of_Pages"),         
				         rs.getString("Book_Subject"),
				         rs.getInt("quantityOfBooks")
				         );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean isBookExist(String bookName) {
		DB_QUERY="Select * from Books where Book_Name=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, bookName);
			rs=ps.executeQuery();
			if(rs.next())
			 return true;
		  } 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public int bookQuantity(String bookName) {
       DB_QUERY="select * from books where Book_Name=?";
       try 
       {
		ps=con.prepareStatement(DB_QUERY);
		ps.setString(1,bookName);
		rs=ps.executeQuery();
		int quantity=0;
		if(rs.next())
		{
			quantity=rs.getInt("quantityOfBooks");
		}
		return quantity;
	   } 
       catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return 0;
	}
	@Override
	public List<Book> ListOfBooks() {
		DB_QUERY="Select * from Books";
		List<Book> book=new ArrayList<Book>();
		try
		{
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				book.add(
						new Book(
						rs.getString("bookid"),
						rs.getString("book_Name"),
						rs.getString("authore_Name"),
						rs.getInt("No_Of_Pages"),
						rs.getString("Book_Subject"),
						rs.getInt("quantityOfBooks"),
						rs.getString("EnrollDate")
						 )
						);
				}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
    public boolean updateQuantity(String bookName)
   {
   System.out.println("Enter 1. If You Want Go BACk << :");
   System.out.println("If Not Then Any key ");
   int key=sc.nextInt();
   switch (key) {
   case 1:
	 if(key==1)
	      break;
  default:
	 System.out.println("Enter Name To Update : ");
	 int quantity=sc.nextInt();
	  DB_QUERY="Update Student set BOOK_QUANTITY=? where BOOO_NAME=?";
      try 
      {
		ps=con.prepareStatement(DB_QUERY);
		ps.setInt(1, quantity);
		ps.setString(2, bookName);
		int count=ps.executeUpdate();
		if(count>0)
		{
			return true;
		}
	  }  
      catch (SQLException e) 
      {
		e.printStackTrace();
	  }
}
     return false;
}
    @Override
    public Integer insertIssuedBook(List<BookOperation> books) {
    	DB_QUERY="Insert into BOOKOperation values(?,?,?,?,?,?,?,?,?,?)";
	    int count[] = null;
	    try 
	    {
		    ps=con.prepareStatement(DB_QUERY);
	     for(BookOperation book:books)
	    {
	    ps.setString(1, UUID.randomUUID().toString());
		ps.setString(2, book.getIssuedBookName());
		ps.setString(3, book.getAuthoreName());
		ps.setString(4, book.getUserName());
		ps.setString(5, book.getUserEmail());
		ps.setString(6, book.getIssuedDate());
		ps.setString(7, book.getReturnDate());
		ps.setInt(8, book.getFine());
		ps.setString(9, book.getDuration());
		ps.setString(10,book.getIssuedTo());
		ps.addBatch();
	    }
		  count=ps.executeBatch();
		  if(count!=null)
		  {
			  return 1;
		  }

	   }
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return 0;
}
    public List<BookOperation> showAllIssuedBook()
    {
    	List<BookOperation> books=new ArrayList<BookOperation>();
		DB_QUERY="Select * from BookOperation";
		try
		{
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				books.add(new BookOperation(rs.getString("IssueBookid"),rs.getString("IssuedBook_Name"),rs.getString("Author_Name"),rs.getString("userName")
						,rs.getString("user_Email"),rs.getString("Issued_Date"),rs.getString("Return_Date"),rs.getInt("Fine"),rs.getString("Duration"),rs.getString("Issued_To")));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return books;
    }
    
    public String issueID_Book()
    {
    	DB_QUERY="Select * from BookOperation where IssuedBook_Name=? and User_Email=?";
    	try {
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			if(rs.getString("Return_Date").equals(null))
			{
				return rs.getString("IssueBookid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    @Override
    public boolean increaseBookQuantity(String bookName,int quantity,int toIncreaseBy) 
   {
         DB_QUERY="update Books set QuantityOfBooks=? where Book_Name=?";
         boolean count = false;
         try 
         {
			ps=con.prepareStatement(DB_QUERY);
			ps.setInt(1, toIncreaseBy+quantity);
			ps.setString(2, bookName);
		     count=ps.executeUpdate()>0;
		 } 
         catch (SQLException e) 
         {
			e.printStackTrace();
		 }
         return count;
   }
    @Override
    public void decreaseBookQuantity(String name,int quantity)
   {
    	int toDecreaseBy=1;
       DB_QUERY="update Books set QuantityOfBooks=? where Book_Name=?";
	   try 
       {
			ps=con.prepareStatement(DB_QUERY);
		    if(quantity>=toDecreaseBy)
			{
			ps.setInt(1, quantity-toDecreaseBy);
			ps.setString(2, name);
			ps.executeUpdate();
			}
		 } 
       catch (SQLException e) 
       {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
   }
    @Override
    public boolean checkUserForIssued() {
	// TODO Auto-generated method stub
	return false;
}
	@Override
	public void returnBook(String Username, String returnDate, int fine, String Duration) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean searchByEmail(String email, String action) {
		DB_QUERY="Select * from BookOperation where User_Email=? and issued_To=?";
    	try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1,email);
			ps.setString(2,action);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
	}
}
