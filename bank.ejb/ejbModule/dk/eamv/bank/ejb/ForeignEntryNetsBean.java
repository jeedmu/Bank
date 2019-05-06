package dk.eamv.bank.ejb;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.domain.Transfer;
import dk.eamv.bank.ejb.entitybeans.BankBean;

@WebService
@Stateless
public class ForeignEntryNetsBean 
{
	@EJB BankBean bbejb;
	@EJB HomeBankingBean hbbejb;
	
	@WebMethod
	public boolean CreateNetsRequest(int fromReg,Entry entry) 
	{
		try {
			/*if(bbejb.read(fromReg).isPresent()) {
				bbejb.read(fromReg).get().getAccountNumber();
			}*/
			int k = bbejb.read(fromReg).get().getAccountNumber();
			Transfer tf = new Transfer();
			tf.getAmount();
			tf.setRegNumber(entry.getRegNumber());
			//tf.getFromAccount().getAccountNumber(k);
			//tf.
			//hbbejb.transferEntry(tf);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// Vi mangler oplysninger om afsendende bank.
		// Den skal bruges til at finde det kontonummer, som pengene skal hæves fra!
		// Derefter skal der laves et Transfer-objekt, som anvendes i kald til 
		// metoden transferEntry i HomeBankingBean
		// Skal afklares med Alex, Jacob og Jonas
	}

}
