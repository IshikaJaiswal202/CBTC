package com.ishika.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ishika.lms.Validation;
import com.ishika.lms.bean.Admin;
import com.ishika.lms.bean.Book;
import com.ishika.lms.bean.BookOperation;
import com.ishika.lms.bean.User;
import com.ishika.lms.bean.User;
import com.ishika.lms.service.IAdminService;
import com.ishika.lms.service.impl.AdminServiceImpl;



public class AdminController extends HttpServlet {
	private static RequestDispatcher rs=null;
	private static final long serialVersionUID = 1L;
	private static Validation valid=null;
	IAdminService admin=null;
   
    public AdminController() {
        super();
        admin=new AdminServiceImpl();
        valid=new Validation();
     }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		switch (action) {
		case "admin": 
               saveAdmin(request,response);
			break;
		
		case "User": 
            saveUser(request,response);
			break;
		case "book": 
            saveBook(request,response);
			break;
		case "adminlogin": 
            loginAdmin(request,response);
			break;	
			
		case "showUser": 
			showUser(request,response);
			break;
		case "showBook": 
			showBook(request,response);
			break;
		case "showIssuedBook": 
			showIssuedBook(request,response);
			break;
		case "deleteUser": 
			deleteUser(request,response);
			break;
			
		case "blockUser": 
			blockUser(request,response);
			break;
		
		case "unBlockUser": 
			unBlockUser(request,response);
			break;
		
		case "editUser": 
			editUser(request,response);
			break;
		case "saveEditUser": 
			saveEditUser(request,response);
			break;
		case "editBook": 
			editBooks(request,response);
			break;
		case "saveEditBook": 
			saveEditBook(request,response);
			break;
		case "saveIssueBook": 
			   saveIssueBook(request,response);
			break;
		case "addIssueBook":
			addIssueBook(request,response);
		default:
			break;
		}
	}
	private void showIssuedBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookOperation> book=admin.showAllIssuedBook();
		request.setAttribute("bookOperation", book);
	     rs=request.getRequestDispatcher("./issuedBooks.jsp");
		 rs.forward(request, response);	
		
	}


	private void addIssueBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String authorName=request.getParameter("author");
		String UserName=request.getParameter("UserName");
		String email=request.getParameter("email");
		String action=request.getParameter("actions");
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		Boolean is=false;
		switch (action) {
		case "User":
			   is=addIssueBookOfUser(name,authorName,UserName,email,action,quantity);
			   break;
		default:
			break;
		}
		if(is)
		{
			request.setAttribute("success", is);
  	        showBook(request, response);
		}
		else
		{
			    request.setAttribute("success", false);
		        rs = request.getRequestDispatcher("./addIssueBook.jsp");
		        rs.include(request, response);
		}
	}
	
      //issue book to the User
    private boolean addIssueBookOfUser(String name, String authorName, String UserName, String email,String action,int quantity) {
    	  List<BookOperation> bop=new ArrayList<BookOperation>();
    	  if(admin.isUserExists(email)&& (valid.issuedBookOnlyTo(email, action)))
    	  {
    			bop=Arrays.asList(new BookOperation(null,name,authorName,UserName,email,"25-7-2024","Pending..",0,"15 Days",action));    
    			admin.saveIssuedBook(bop);
    			admin.decreaseBookQuantity(name,quantity);
    			return true;
    	  }
    	  return false;
	}


	// get name of book and author for add issue book
	private void saveIssueBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String authorName=request.getParameter("authorName");
		String actions=request.getParameter("actionsTo");
		String quantity=request.getParameter("bookQuantity");
		request.setAttribute("bookName",name);
		request.setAttribute("authorName",authorName);
		request.setAttribute("action",actions);
		request.setAttribute("action",actions);
		request.setAttribute("quantity",quantity);
		rs=request.getRequestDispatcher("./addIssueBook.jsp");
		rs.forward(request, response);
		
	}


	//list of booksW
	private void showBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> book=admin.ListOfBooks();
		request.setAttribute("books", book);
	     rs=request.getRequestDispatcher("./bookPanel.jsp");
		 rs.forward(request, response);	
	}


	//edit the User (getting the information of User) 
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
	    User stud=admin.showUserDetail(email);
		request.setAttribute("Users", stud);
		rs=request.getRequestDispatcher("./editUser.jsp");
		rs.forward(request, response);
		
	}
	//update the User
    private void saveEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      String name=request.getParameter("name");
      String email=request.getParameter("email");
      String contact=request.getParameter("contact");
      String address=request.getParameter("address");
      if(admin.updateUser(email, name, contact, address))
    	  request.setAttribute("User",true);
      else
         request.setAttribute("User",false);
      editUser(request, response);
      
    }
    
  
  	
    
    
    
  //edit the books (getting the information of Books) 
  	private void editBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		request.setAttribute("name", request.getParameter("name"));
  		request.setAttribute("author", request.getParameter("authorName"));
  		request.setAttribute("stream", request.getParameter("stream"));
  		request.setAttribute("pages", request.getParameter("pages"));
  		request.setAttribute("quantity",request.getParameter("bookQuantity"));
  		rs=request.getRequestDispatcher("./editBook.jsp");
  		rs.forward(request, response);
  		
  	}
    //update the Books 
    private void saveEditBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      Integer quantity=Integer.parseInt(request.getParameter("quantity"));
      Integer quantityOld=Integer.parseInt(request.getParameter("quantityOf"));
      String name=request.getParameter("name");
		  if(admin.increaseBookQuantity(name, quantityOld, quantity))
		  request.setAttribute("books",true);
		  else
		  request.setAttribute("books",false); 
		  showBook(request, response);
		 
    }
	//block User
	private void blockUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		admin.statusChange(email,"Block");
		showUser(request, response);
	}
	
	
	//unBlock The User
	private void unBlockUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		admin.statusChange(email,"true");
		showUser(request, response);
	}
	

	//delete the User
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		admin.removeUser(email);
		showUser(request, response);
	}
	
	
	// list of all the User
    private void showUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> stud=admin.ListOFAllUser();
		request.setAttribute("Users", stud);
	     rs=request.getRequestDispatcher("./UserPanel.jsp");
		rs.forward(request, response);
		
	}
     
 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	// login of admin
	public void loginAdmin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
        String msg="";
	   String email=request.getParameter("email");
	  if(admin.isAdminByEmail(email))
	  {
		  String password=request.getParameter("password");
		  if(admin.loginAdmin(email, password))
		  {
			 rs=request.getRequestDispatcher("./adminDashboard.jsp");
			 rs.forward(request, response);
		  }
		  else
		  {
			  msg="<h1><p style='color: red;'>Invalid Password !!</p></h1>";
			  response.setContentType(msg);
			  out.print(msg);
			   rs=request.getRequestDispatcher("./adminLogin.jsp");
			  rs.include(request, response);
		  }
	   }
	  else
	  {
		    msg="<h1 style='text-align: center;  margin-top:11px;'><p style='color: red;'>Email Does Not Match </p></h1>";
		    response.setContentType(msg);
			out.print(msg);
			 rs=request.getRequestDispatcher("./adminLogin.jsp");
			rs.include(request, response); 
		}
	}
	
	//add Book
		public void saveBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		    String name = request.getParameter("name");
		    String authore = request.getParameter("authore");
		    if (admin.isBookExist(name)) {
		        request.setAttribute("success", false);
		        rs = request.getRequestDispatcher("./addBook.jsp");
		        rs.include(request, response);
		    } else {
		        Integer page    = Integer.parseInt(request.getParameter("noOfPage"));
		        String  subject = request.getParameter("subject");
		        Integer quantity= Integer.parseInt(request.getParameter("quantity"));
		        List<Book> list = Arrays.asList(new Book(null, name, authore, page, subject, quantity,  "20-1-2022"));
		        admin.saveBooks(list);
		        request.setAttribute("success", true);
		        rs= request.getRequestDispatcher("./addBook.jsp");
		        rs.forward(request, response);
		    }
		}
	//add User
	public void saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    if (admin.isUserExists(email)) {
	        request.setAttribute("success", false);
	        rs = request.getRequestDispatcher("./addUser.jsp");
	        rs.include(request, response);
	    } else {
	        String password = request.getParameter("password");
	        String contact = request.getParameter("contact");
	        String address = request.getParameter("address");
	        List<User> list = Arrays.asList(new User(null, name, email, password, contact, address, "true", "20-1-2022"));
	        admin.saveUser(list);
	        request.setAttribute("success", true);
	        rs= request.getRequestDispatcher("./addUser.jsp");
	        rs.forward(request, response);
	    }
	}
	
	
	//add admin 
	public void saveAdmin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		 String name= request.getParameter("name");
		 String email= request.getParameter("email");
         if(admin.isAdminByEmail(email))
		  {
			               request.setAttribute("success",false);
						   rs=request.getRequestDispatcher("./addAdmin.jsp");
						   rs.include(request, response);
		  }
		  else
		  {
			  String password= request.getParameter("password");
			  String contact= request.getParameter("contact");
			  String address= request.getParameter("address");
			  List<Admin> list=Arrays.asList(new Admin(null,name,email,password,contact,address,"true","20-1-2022"));
			  admin.saveAdmin(list);
			  request.setAttribute("success", true);
		       rs = request.getRequestDispatcher("./addAdmin.jsp");
		      rs.forward(request, response);
		  }
	}
	
	
	

}
