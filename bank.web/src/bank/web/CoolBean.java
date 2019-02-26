package bank.web;


import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CoolBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}