package com.ishika.lms.service.impl;
import com.ishika.lms.bean.User;
import com.ishika.lms.dao.IUserDao;
import com.ishika.lms.dao.impl.UserDaoImpl;
import com.ishika.lms.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao UserDao= null;
	public UserServiceImpl() {
		UserDao=new UserDaoImpl();
	}
	@Override
	public boolean loginUser(String email, String password) {
		return UserDao.login(email, password);
	      
	}

	@Override
	public void updateUser(String email,String name,String contact,String address) {
		UserDao.updateUser(email,name,contact,address);
	}
    
	@Override
	public User showUserData(String email) {
        return UserDao.showDetailByEmail(email);
	}

}
