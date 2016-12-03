package com.jlcindia.struts;

public class DAOFactory {

	static ContactDAO contactDAO;
	static{
		contactDAO=new JDBCContactDAO();
		//DMD 
	}
	
	public static ContactDAO getContactDAO(){
		return contactDAO;
	}
}
