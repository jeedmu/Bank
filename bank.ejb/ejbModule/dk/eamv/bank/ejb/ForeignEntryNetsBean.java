package dk.eamv.bank.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import dk.eamv.bank.domain.Entry;

@WebService
@Stateless
public class ForeignEntryNetsBean 
{
	@WebMethod
	public boolean CreateNetsRequest(Entry entry) 
	{
		// 
		return false;
	}
}
