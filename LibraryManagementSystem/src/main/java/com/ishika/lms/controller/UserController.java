package com.ishika.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ishika.lms.service.IAdminService;
import com.ishika.lms.service.IUserService;
import com.ishika.lms.service.impl.AdminServiceImpl;
import com.ishika.lms.service.impl.UserServiceImpl;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IAdminService admin=null;
       private IUserService User=null;
    
    public UserController() {
        super();
        admin=new AdminServiceImpl();
        User=new UserServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    loginUser(request, response);
	}
	public void loginUser(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("ishika");
		PrintWriter out=response.getWriter();
        String msg="";
        RequestDispatcher rs;
	   String email=request.getParameter("email");
	  if(admin.isUserExists(email))
	  {
		  String password=request.getParameter("password");
		  if(User.loginUser(email, password))
		  {
			 rs=request.getRequestDispatcher("./UserDashboard.jsp");
			 rs.forward(request, response);
		  }
		  else
		  {
			  msg="<h1><p style='color: red;'>Invalid Password !!</p></h1>";
			  response.setContentType(msg);
			  out.print(msg);
			   rs=request.getRequestDispatcher("./UserLogin.jsp");
			  rs.include(request, response);
		  }
	   }
	  else
	  {
		    msg="<h1 style='text-align: center;  margin-top:11px;'><p style='color: red;'>Email Does Not Match </p></h1>";
		    response.setContentType(msg);
			out.print(msg);
			 rs=request.getRequestDispatcher("./UserLogin.jsp");
			rs.include(request, response); 
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
