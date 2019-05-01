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
		// Vi mangler oplysninger om afsendende bank.
		// Den skal bruges til at finde det kontonummer, som pengene skal hæves fra!
		// Derefter skal der laves et Transfer-objekt, som anvendes i kald til 
		// metoden transferEntry i HomeBankingBean
		// Skal afklares med Alex, Jacob og Jonas
		
		return false;
	}
}
