package com.ishika.lms.service;


import com.ishika.lms.bean.User;

public interface IUserService {
	public boolean loginUser(String email,String password);
	public void updateUser(String email,String name,String contact,String address);
    public User showUserData(String email);
}
