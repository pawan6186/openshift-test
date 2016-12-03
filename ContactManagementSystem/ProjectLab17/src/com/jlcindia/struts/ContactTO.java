package com.jlcindia.struts;

public class ContactTO {

	private String contactId;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String status;
	
	public ContactTO(){}

	public ContactTO(String contactId, String fname, String lname,
			String email, String phone, String status) {
		super();
		this.contactId = contactId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}

	public ContactTO(String fname, String lname, String email, String phone,
			String status) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.status = status;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
	
	