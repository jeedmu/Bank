package dk.eamv.bank.ejb;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entitybeans.EntryBean;

@Stateless
public class TimerFutureEntriesBean {

	@EJB EntryBean e;
	
	@Schedule(minute="*/1", hour="*")
	public void handleEntries()
	{
		Entry entry = new Entry.Builder().setDate(LocalDateTime.now()).setAmount(BigDecimal.ONE).setDescription("").build();
		e.create(entry);
		Entry entry2 = new Entry.Builder().setDate(LocalDateTime.now().plusDays(1)).setAmount(BigDecimal.ONE).setDescription("").build();
		e.create(entry2);
		Entry entry3 = new Entry.Builder().setDate(LocalDateTime.now().minusDays(1)).setAmount(BigDecimal.ONE).setDescription("").build();
		e.create(entry3);
		System.out.println("asd "+e.list2().size());
	}
}
