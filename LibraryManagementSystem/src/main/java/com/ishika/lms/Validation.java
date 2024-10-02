package com.ishika.lms;

import com.ishika.lms.service.IAdminService;
import com.ishika.lms.service.impl.AdminServiceImpl;

public class Validation
{ 
	 private IAdminService adminService=null;
	 
    public Validation() {
		super();
		adminService=new AdminServiceImpl();
	}

	public boolean issuedBookOnlyTo(String email,String action)
    {
     if(adminService.searchByEmail(email, action))
        	 return false;
        	
		return true;
	}
}
