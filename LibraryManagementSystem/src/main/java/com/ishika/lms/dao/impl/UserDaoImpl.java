package com.ishika.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import com.ishika.lms.bean.User;
import com.ishika.lms.dao.IUserDao;
import com.ishika.lms.util.DBCon;

public class UserDaoImpl implements IUserDao {
	Scanner sc=new Scanner(System.in);
    Connection con=null;
    String DB_QUERY=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public UserDaoImpl()  {
		super();
		con=DBCon.getConnection();
	}
	@Override
	public Integer insertUser(List<User> Users) {
		DB_QUERY="Insert into User values(?,?,?,?,?,?,?,?)";
		System.out.println(DB_QUERY);
		int[] count=null;
    	try 
    	{
    		ps=con.prepareStatement(DB_QUERY);
    		for(User User:Users)
    		{
    		ps.setString(1, UUID.randomUUID().toString());
    		ps.setString(2, User.getUser_name() );
    		ps.setString(3, User.getUser_email());
    		ps.setString(4, User.getUser_password());
    		ps.setString(5, User.getUser_contact());
    		ps.setString(6, User.getUser_address());
    		ps.setString(7, User.getUser_isActive());
    		ps.setString(8, User.getUser_createDate());
    		ps.addBatch();
    		}
    		 count=ps.executeBatch();
    		}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
		return count.length;
	}

	@Override
	public boolean login(String email, String password) {
		 DB_QUERY="Select * from User where User_Email=? and User_Password=?";
		    try {
				ps=con.prepareStatement(DB_QUERY);
				ps.setString(1,email);
				ps.setString(2, password);
				rs=ps.executeQuery();
			    } 
		    catch (SQLException e1) {
				e1.printStackTrace();
			}
		     try {
				if(rs.next())
				{
					return true;
				}
			} 
		     catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     return false;
	}

	@Override
	public boolean remove_User(String email) {
		DB_QUERY="Delete from User where User_email=?";
		try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, email);
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
	public List<User> ListOFAll_User() {
		DB_QUERY="Select * from User";
		List<User> stud=new ArrayList<User>();
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				{
				    stud.add(new User(rs.getString("Uid"),rs.getString("User_Name"),
						rs.getString("User_Email"),rs.getString("User_Contact"),
						rs.getString("User_Address"),rs.getString("User_status"),
						rs.getString("createdDate")));
				}
		    }
			
		} 
		catch(Exception e)
		{
			e.getMessage();
		}
		return stud;
	}

	@Override
	public void searchByName_User(String name) {
		DB_QUERY="Select *  from User where User_Name=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, name);
			rs=ps.executeQuery();
			int f=0;
			String UserName=null;
		    while(rs.next())
			{
		     f=1;
		     UserName=rs.getString("User_Name");
		     System.out.print(UserName+"          ");
	    	 System.out.print(rs.getString("User_Email")+"         ");
	    	 System.out.print(rs.getString("User_Contact")+"        ");
	    	 System.out.print(rs.getString("User_Address")+"       ");
	    	 System.out.print(rs.getString("User_status")+"       ");
	    	 System.out.println(rs.getString("CreatedDate")+"       ");
	    	 System.out.println("-----------------------------------------------------------------------------------------------");
	    	 
			}
			if(f==0)
			{
				System.out.println(" No One Exists With this "+name);
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
    public boolean updateUser(String email,String name,String contact,String address)
    {
      DB_QUERY="Update User set User_name=?,User_contact=?,User_address=? where User_email=?";
      try {
		ps=con.prepareStatement(DB_QUERY);
		ps.setString(1, name);
		ps.setString(2, contact);
		ps.setString(3, address);
		ps.setString(4, email);
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
      
     return false;
    }
    
	@Override
	public User showDetailByEmail(String email) {
		DB_QUERY="Select * from User where User_Email=?";
		User User=null;
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				User=new User(
						rs.getString("User_Name"),
						rs.getString("User_Email"),
						rs.getString("User_Password"),
						rs.getString("User_Contact"),
						rs.getString("User_Address")
						);
		    }
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return User;

	}

	@Override
	public void changeStatus(String email, String status) {
		DB_QUERY="update User set User_status=? where User_email=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, status);
			ps.setString(2,email);
			ps.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean isUserExixts(String email) {
		DB_QUERY="Select * from User where User_Email=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
			{
		     return true;
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	@Override
	public boolean isUserActive(String email) {
		DB_QUERY="Select * from User where User_Email=?";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, email);
			rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString("User_Status")=="true")
		        return true;
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
