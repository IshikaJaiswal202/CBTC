package com.ishika.lms.dao;

import java.util.List;

import com.ishika.lms.bean.User;
public interface IUserDao 
{
	public Integer insertUser(List<User> Users); 
    public boolean login(String email,String password);
    public boolean remove_User(String email);
    public List<User> ListOFAll_User();
    public void searchByName_User(String name);
    public boolean updateUser(String email,String name,String contact,String address);
    public User showDetailByEmail(String email);
    public void changeStatus(String email,String status);
    public boolean isUserExixts(String email);
	public boolean isUserActive(String email);
}
