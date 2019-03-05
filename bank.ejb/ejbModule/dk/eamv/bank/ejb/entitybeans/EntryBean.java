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
	
	 public List<Entry> list(String search){
	    	return em.createNamedQuery("searchEntries", EntryEntity.class)
	    				.setParameter("search", "%" + search.toUpperCase() + "%")
	    				.getResultList()
	    				.stream()
	    				.map(e -> e.toDomain())
	    				.collect(Collectors.toList());
	    				
	    }
	
}
