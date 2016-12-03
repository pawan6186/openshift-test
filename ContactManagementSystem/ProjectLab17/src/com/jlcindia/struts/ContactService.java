package com.jlcindia.struts;

import java.util.*;

public interface ContactService {
	public int addContact(ContactTO cto);
	public int updateContact(ContactTO cto);
	public ContactTO getContactByEmail(String email);
	public List<ContactTO> getAllContacts(int start,int total);
	public int getTotalNumberOfRecords();
	public int deleteContact(String cid);

}
