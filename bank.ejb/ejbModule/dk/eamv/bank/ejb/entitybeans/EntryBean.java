package dk.eamv.bank.ejb.entitybeans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Entry;
import dk.eamv.bank.ejb.entity.AccountEntity;
import dk.eamv.bank.ejb.entity.EntryEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
