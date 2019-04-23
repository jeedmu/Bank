package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entity.EntryEntity;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;
import dk.eamv.bank.ejb.exception.EntryAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.EntryNotFoundException;

/**
 * Session Bean implementation class EntryBean
 */
@Stateless
@LocalBean
public class FutureEntryBean {
	@PersistenceContext private EntityManager em;


	
	 public List<Entry> list(int accountNumber, int regNumber){
	    	return em.createNamedQuery("searchEntriesForAccount", EntryEntity.class)
	    				.setParameter("accountNumber", "=" + accountNumber)
	    				.setParameter("regNumber", "=" + regNumber)
	    				.getResultList()
	    				.stream()
	    				.map(e -> e.toDomain())
	    				.collect(Collectors.toList());
	    				
	    }
	
}
