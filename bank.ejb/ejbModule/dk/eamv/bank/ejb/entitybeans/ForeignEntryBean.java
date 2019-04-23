package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entity.ForeignEntryEntity;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;
import dk.eamv.bank.ejb.exception.EntryAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.EntryNotFoundException;

/**
 * Session Bean implementation class EntryBean
 */
@Stateless
@LocalBean
public class ForeignEntryBean {
	@PersistenceContext private EntityManager em;

	public void create(Entry entry) {
		Optional<Entry> optional = read(entry.getEntryID());
		if (optional.isPresent()) {
			throw new EntryAlreadyExsistsException();
		} else {
			em.persist(new ForeignEntryEntity(entry));
		}
	}
	
	public Optional<Entry> read(long entryID){
		ForeignEntryEntity entity = em.find(ForeignEntryEntity.class, entryID);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Entry entry) {
		ForeignEntryEntity entity = em.find(ForeignEntryEntity.class, entry.getEntryID());
		if (entity != null) {
			entity.setDescription(entry.getDescription());
		} else {
			throw new EntryNotFoundException();
		}
	}
	
	public void delete(long entryID) {
		ForeignEntryEntity entity = em.find(ForeignEntryEntity.class, entryID);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	 public List<Entry> list(int accountNumber){
	    	return em.createNamedQuery("searchEntries", ForeignEntryEntity.class)
	    				.setParameter("accountNumber", "%" + accountNumber + "%")
	    				.getResultList()
	    				.stream()
	    				.map(e -> e.toDomain())
	    				.collect(Collectors.toList());	
	    }
	
}
