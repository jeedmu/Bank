package dk.eamv.bank.homebanking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.HomeBanking;

@Named
@RequestScoped
public class AccountOverviewBean implements Serializable {

	@EJB
	private HomeBanking homeBanking;
	private static final long serialVersionUID = 1L;
	private int customerID;

	public List<Account> getAccounts() {
//		ArrayList<Account> ac = new ArrayList<Account>();
//		ac.add(new Account.Builder(25, 9108, 24242424).setBalance(BigDecimal.ZERO).setAccountName("Opsparing").build());
//		ac.add(new Account.Builder(11, 2201, 894891981).setBalance(BigDecimal.ONE).setAccountName("Ferie").build());
//		ac.add(new Account.Builder(34, 3487, 348584598)
//				.setBalance(BigDecimal.TEN.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).multiply(BigDecimal.TEN))
//				.setAccountName("Kort").build());
//		return ac;
		String userID = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		this.customerID = homeBanking.getCustomerID(userID);
		return homeBanking.showAccounts(this.customerID);
	}

	public List<Entry> getEntries(String accountNo) {
		List<Entry> entries = new ArrayList<Entry>();
		if (accountNo.equals("24242424"))
			entries.add(new Entry.Builder().setEntryID(0).setDate(LocalDateTime.now())
					.setAmount(BigDecimal.ZERO.subtract(BigDecimal.TEN)).setAccountNumber(12391923).setRegNumber(0)
					.setDescription("Pakke").build());
		entries.add(new Entry.Builder().setEntryID(0).setDate(LocalDateTime.now())
				.setAmount(BigDecimal.TEN.multiply(BigDecimal.TEN)).setAccountNumber(12391923).setRegNumber(0)
				.setDescription("Løn").build());
		entries.add(new Entry.Builder().setEntryID(0).setDate(LocalDateTime.now())
				.setAmount(BigDecimal.ZERO.subtract(BigDecimal.TEN)).setAccountNumber(12391923).setRegNumber(0)
				.setDescription("Regning").build());
		return entries;
		// return homeBanking.showEntries(accountNo, noOfDays, regNumber);
	}

	public String GetDate(Entry entry) {
		return entry.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)).replaceAll("/", "-");
	}
}