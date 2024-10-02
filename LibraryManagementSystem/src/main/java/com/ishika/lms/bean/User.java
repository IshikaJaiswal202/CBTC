package com.ishika.lms.bean;

public class User 
{
		    private String user_id;
		    private String user_name;
		    private String user_email;
		    private String user_password;
		    private String user_contact;
		    private String user_address;
		    private String user_isActive;
		    private String user_createDate;
			public User() {
				super();
			}
			public User(String user_id, String user_name, String user_email, String user_password,
					String user_contact, String user_address, String user_isActive,
					String user_createDate) {
				super();
				this.user_id = user_id;
				this.user_name = user_name;
				this.user_email = user_email;
				this.user_password = user_password;
				this.user_contact = user_contact;
				this.user_address = user_address;
				this.user_isActive = user_isActive;
				this.user_createDate = user_createDate;
			}
			public User(String user_name, String user_email, String user_password,
					String user_contact, String user_address
					) {
				super();
				this.user_name = user_name;
				this.user_email = user_email;
				this.user_password = user_password;
				this.user_contact = user_contact;
				this.user_address = user_address;
			}
			public User(String user_id, String user_name, String user_email,
					String user_contact, String user_address, String user_isActive,
					String user_createDate) {
				super();
				this.user_id = user_id;
				this.user_name = user_name;
				this.user_email = user_email;
				this.user_contact = user_contact;
				this.user_address = user_address;
				this.user_isActive = user_isActive;
				this.user_createDate = user_createDate;
			}
		
			
			
			
			public String getUser_id() {
				return user_id;
			}
			public void setUser_id(String user_id) {
				this.user_id = user_id;
			}
			public String getUser_name() {
				return user_name;
			}
			public void setUser_name(String user_name) {
				this.user_name = user_name;
			}
			public String getUser_email() {
				return user_email;
			}
			public void setUser_email(String user_email) {
				this.user_email = user_email;
			}
			public String getUser_password() {
				return user_password;
			}
			public void setUser_password(String user_password) {
				this.user_password = user_password;
			}
			public String getUser_contact() {
				return user_contact;
			}
			public void setUser_contact(String user_contact) {
				this.user_contact = user_contact;
			}
			public String getUser_address() {
				return user_address;
			}
			public void setUser_address(String user_address) {
				this.user_address = user_address;
			}
			public String getUser_isActive() {
				return user_isActive;
			}
			public void setUser_isActive(String user_isActive) {
				this.user_isActive = user_isActive;
			}
			public String getUser_createDate() {
				return user_createDate;
			}
			public void setUser_createDate(String user_createDate) {
				this.user_createDate = user_createDate;
			}
			@Override
			public String toString() {
				return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_email="
						+ user_email + ", user_password=" + user_password + ", user_contact="
						+ user_contact + ", user_address=" + user_address + ", user_isActive="
						+ user_isActive + ", user_createDate=" + user_createDate + "]";
			}
		    
}
