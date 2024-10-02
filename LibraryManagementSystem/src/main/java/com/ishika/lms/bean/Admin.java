package com.ishika.lms.bean;

public class Admin {
	   private String admin_id;
	   private String admin_name;
	   private String admin_email;
	   private String admin_password;
	   private String admin_contact;
	   private String admin_address;
	   private String isActive;
	   private String createDate;
	   public Admin() 
	   {
		super();
	   }
	   
	   public Admin(String admin_id, String admin_name, String admin_email, String admin_password, String admin_contact,
			String admin_address, String isActive, String createDate)
	   {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_email = admin_email;
		this.admin_password = admin_password;
		this.admin_contact = admin_contact;
		this.admin_address = admin_address;
		this.isActive = isActive;
		this.createDate = createDate;
	  }
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_email() {
		return admin_email;
	}
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}
	public String getAdmin_address() {
		return admin_address;
	}
	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", admin_email=" + admin_email
				+ ", admin_password=" + admin_password + ", admin_contact=" + admin_contact + ", admin_address="
				+ admin_address + ", isActive=" + isActive + ", createDate=" + createDate + "]";
	}
	 
	   
	     
	   
	  	   
	    
	   
}
