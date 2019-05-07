package dk.eamv.bank.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.domain.Transfer;
import dk.eamv.bank.ejb.entitybeans.AccountBean;
import dk.eamv.bank.ejb.entitybeans.BankBean;
import dk.eamv.bank.ejb.entitybeans.CustomerBean;

@WebService
@Stateless
public class ForeignEntryNetsBean 
{
	@EJB BankBean bbejb;
	@EJB AccountBean abejb;
	@EJB CustomerBean cbejb;
	
	@WebMethod
	public boolean CreateNetsRequest(int fromReg,Entry entry, Account fromAccount, String description){
		try {
			/*if(bbejb.read(fromReg).isPresent()) {
				bbejb.read(fromReg).get().getAccountNumber();
			}*/
			Transfer transfer = new Transfer();
			int accountNumber = bbejb.read(fromReg).get().getAccountNumber();
			int customerID = abejb.read(accountNumber).get().getCustomerID();
			
			transfer.setAmount(entry.getAmount());
			transfer.setFromAccount(abejb.read(accountNumber).get());
			transfer.setToAccountAccountNumber(accountNumber);
			transfer.setFromDescription("Overførsel fra " + fromReg);			
			transfer.setToDescription(entry.getDescription());
			transfer.setRegNumber(entry.getRegNumber());
			transfer.setAmount(entry.getAmount());
			transfer.setFromAccount(abejb.read(accountNumber).get());
			transfer.setToAccountAccountNumber(accountNumber);
			transfer.setFromDescription("Overførsel fra " + fromReg);			
			transfer.setToDescription(entry.getDescription());
			transfer.setRegNumber(entry.getRegNumber());
			transfer.setCurrentCustomer(cbejb.read(customerID).get());
			transfer.setDate(entry.getDate());
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
	}
}
