package com.ishika.lms.dao;

import java.util.List;

import com.ishika.lms.bean.Admin;

public interface IAdminDao {
	   public  Integer insertAdmin(List<Admin> admins);
	   public  boolean isAdminExists();
	   public  void changeAdminStatus(String admin_email,String status);
	   public  boolean login(String admin_email,String admin_password );
	   public  boolean isAdminByEmail(String email);
}
