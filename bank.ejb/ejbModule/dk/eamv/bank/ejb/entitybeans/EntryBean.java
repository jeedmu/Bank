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
public class EntryBean {
	@PersistenceContext private EntityManager em;

	public void create(Entry entry) {
		Optional<Entry> optional = read(entry.getEntryID());
		if (optional.isPresent()) {
			throw new EntryAlreadyExsistsException();
		} else {
			em.persist(new EntryEntity(entry));
		}
	}
	
	public Optional<Entry> read(long entryID){
		EntryEntity entity = em.find(EntryEntity.class, entryID);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Entry entry) {
		EntryEntity entity = em.find(EntryEntity.class, entry.getEntryID());
		if (entity != null) {
			entity.setDescription(entry.getDescription());
		} else {
			throw new EntryNotFoundException();
		}
	}
	
	public void delete(long entryID) {
		EntryEntity entity = em.find(EntryEntity.class, entryID);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	 public List<Entry> list(int accountNumber, int regNumber){
	    	return em.createNamedQuery("searchEntriesForAccount", EntryEntity.class)
	    				.setParameter("accountNumber", "=" + accountNumber)
	    				.setParameter("regNumber", "=" + regNumber)
	    				.getResultList()
	    				.stream()
	    				.map(e -> e.toDomain())
	    				.collect(Collectors.toList());
	    				
	    }
	 public List<Entry> list2(){
	    	return em.createNamedQuery("futureEntries", EntryEntity.class)
	    				.getResultList()
	    				.stream()
	    				.map(e -> e.toDomain())
	    				.collect(Collectors.toList());
	    				
	    }

	
}
