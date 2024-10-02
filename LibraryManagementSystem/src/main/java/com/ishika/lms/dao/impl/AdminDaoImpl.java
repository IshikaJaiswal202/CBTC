package com.ishika.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.ishika.lms.bean.Admin;
import com.ishika.lms.dao.IAdminDao;
import com.ishika.lms.util.DBCon;

public class AdminDaoImpl implements IAdminDao {
	Scanner sc=null;
    Connection con=null;
    String DB_QUERY=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public AdminDaoImpl()
    {
    	super();
    	
	   try {
		this.con= DBCon.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	 
    public Integer insertAdmin(List<Admin> admins) {
    	DB_QUERY="Insert into ADMIN values(?,?,?,?,?,?,?,?)";
    	try 
    	{
    		ps=con.prepareStatement(DB_QUERY);
    		for(Admin admin:admins)
    		{
    		ps.setString(1,UUID.randomUUID().toString());
    		ps.setString(2, admin.getAdmin_name());
    		ps.setString(3, admin.getAdmin_email());
    		ps.setString(4, admin.getAdmin_password());
    		ps.setString(5,admin.getAdmin_contact());
    		ps.setString(6, admin.getAdmin_address());
    		ps.setString(7,admin.getIsActive());
    		ps.setString(8, admin.getCreateDate());
    		ps.addBatch();
    		}
    	}
    	catch (SQLException e)
    	{
    		System.out.println("This Email already exists Pls Enter once ");
    	}
         int count[]=null;
    	try
    	{       
    	  count=ps.executeBatch();
    	} 
    	catch (SQLException e)
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return count.length;
	}
	
	public boolean login(String UserEmail, String Userpassword) {
	    DB_QUERY="Select * from Admin where Admin_Email=? and Admin_Password=?";
	    try {
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1,UserEmail);
			ps.setString(2, Userpassword);
			rs=ps.executeQuery();
		    } 
	    catch (SQLException e1) {
			e1.printStackTrace();
		}
	     try 
	     {
			if(rs.next())
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
	public void changeAdminStatus(String email,String status) {
		DB_QUERY="update Admin set admin_status=? where Admin_email=?";
		boolean count=false;
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			ps.setString(1, status);
			ps.setString(2,email);
			count=ps.executeUpdate()>0;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(count!=true)
		{
			System.out.println("Failed to Update");
		}
		else
			System.out.println("Status Changed succesffully");
	}

	@Override
	public boolean isAdminExists() {
		DB_QUERY="select * from Admin";
		try 
		{
			ps=con.prepareStatement(DB_QUERY);
			rs=ps.executeQuery();
			if(rs.next())
				return true; 
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean isAdminByEmail(String email) {
		DB_QUERY="select * from Admin where admin_Email=?";
		try
		{
		ps=con.prepareStatement(DB_QUERY);
		ps.setString(1, email);
		rs=ps.executeQuery();
		if(rs.next())
			return true; 
		}
		catch (Exception e) {}
		return false;
	}

}
