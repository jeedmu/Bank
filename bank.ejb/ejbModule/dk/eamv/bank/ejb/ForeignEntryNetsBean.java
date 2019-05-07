package dk.eamv.bank.ejb;

import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import dk.eamv.bank.domain.Account;
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
	public boolean CreateNetsRequest(int fromReg,Entry entry, Account fromAccount, String description) 
	{
		try {
			/*if(bbejb.read(fromReg).isPresent()) {
				bbejb.read(fromReg).get().getAccountNumber();
			}*/
			int accountNumber = bbejb.read(fromReg).get().getAccountNumber();
			Transfer transfer = new Transfer();
			//transfer.setAmount();
			transfer.setFromAccount(fromAccount);
			transfer.setToAccountAccountNumber(accountNumber);			
			transfer.setToDescription(description);			
			transfer.setRegNumber(entry.getRegNumber());
			//transfer.setCurrentCustomer(currentCustomer);
			//transfer.setDate(date);

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
