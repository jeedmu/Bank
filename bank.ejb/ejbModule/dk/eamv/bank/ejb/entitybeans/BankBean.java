package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.ejb.entity.AccountEntity;
import dk.eamv.bank.ejb.entity.BankEntity;
import dk.eamv.bank.ejb.entity.CustomerEntity;

/**
 * Session Bean implementation class BankBean
 */
@Stateless
@LocalBean
public class BankBean {

	@PersistenceContext private EntityManager em;
	
	public void create(Bank bank) throws BankAlreadyExsistsException{
		Optional<Bank> optional = read(bank.getCVR());
		if (optional.isPresent()) {
			throw new BankAlreadyExsistsException();
		} else {
			em.persist(new BankEntity(bank));
		}
	}
	
	public Optional<Bank> read(String cvr){
		BankEntity entity = em.find(BankEntity.class, cvr);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Bank bank) throws BankNotFoundException {
		BankEntity entity = em.find(BankEntity.class, bank.getCVR());
		if (entity != null) {
			entity.setBankName(bank.getBankName());
			entity.setRegNumber(bank.getRegNumber());
			entity.setPhoneNumber(bank.getPhoneNumber());
		} else {
			throw new BankNotFoundException();
		}
	}
	
	public void delete(String cvr) throws BankNotFoundException {
		BankEntity entity = em.find(BankEntity.class, cvr);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new BankNotFoundException();
		}
	}
	
	 public List<Bank> list(String search){
	    	return em.createNamedQuery("searchBanks", BankEntity.class)
	    				.setParameter("search", "%" + search.toUpperCase() + "%")
	    				.getResultList()
	    				.stream()
	    				.map(b -> b.toDomain())
	    				.collect(Collectors.toList());
	    				
	    }
	
}
