package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.ejb.entity.BankEntity;
import dk.eamv.bank.ejb.entity.ZipCodeEntity;
import dk.eamv.bank.ejb.exception.BankAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.BankNotFoundException;

/**
 * Session Bean implementation class BankBean
 */
@Stateless
@LocalBean
public class BankBean {
	@EJB ZipCodeBean zCB;
	@PersistenceContext private EntityManager em;
	
	public void create(Bank bank) {
		Optional<Bank> optional = read(bank.getRegNumber());
		if (optional.isPresent()) {
			throw new BankAlreadyExsistsException();
		} else {
			em.persist(new BankEntity(bank));
		}
	}
	
	public Optional<Bank> read(int regNumber){
		BankEntity entity = em.find(BankEntity.class, regNumber);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Bank bank) {
		BankEntity entity = em.find(BankEntity.class, bank.getRegNumber());
		if (entity != null) {
			
			Optional<ZipCodeEntity> zipCode = zCB.read(bank.getZipCode());
    		ZipCodeEntity zipEntity = null;
    		if(zipCode.isEmpty()) {
    			zipEntity = new ZipCodeEntity(bank.getZipCode(), bank.getCity());
    			zCB.create(zipEntity);
    		}
    		else {
    			zipEntity = zipCode.get();
    		}
			entity.setBankName(bank.getBankName());
			entity.setRegNumber(bank.getRegNumber());
			entity.setPhoneNumber(bank.getPhoneNumber());
			entity.setAddress(bank.getAddress());
			entity.setCountry(bank.getCountry());
		} else {
			throw new BankNotFoundException();
		}
	}
	
	public void delete(String address) {
		BankEntity entity = em.find(BankEntity.class, address);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new BankNotFoundException();
		}
	}
	
	 public List<Bank> getBanks(){
	    	return em.createNamedQuery("AllBanks", BankEntity.class)
	    				.getResultList()
	    				.stream()
	    				.map(b -> b.toDomain())
	    				.collect(Collectors.toList());
	    				
	   }
	 

	
}
