package com.jlcindia.struts;

import org.apache.struts.actions.DispatchAction;

public class JLCBaseDispatchAction extends DispatchAction{
	static ContactService contactService;
	
	static{
		contactService=new ContactServiceImpl();
	}

}
