package dk.eamv.bank.ejb.entitybeans;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerChanges;
import dk.eamv.bank.ejb.entity.CustomerChangesEntity;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;

/**
 * Session Bean implementation class CustomerChangeBean
 */
@Stateless
@LocalBean
public class CustomerChangeBean {
	@PersistenceContext private EntityManager em;
	CustomerBean cb;
	
	@Schedule(minute = "*/1", hour = "*")
	public void checkForChanges() {
		System.out.println("CustomerChangeBean");
		List<CustomerChanges> listOfCustomerChanges = list();
		for(CustomerChanges changes : listOfCustomerChanges) {
			if(changes.getChangeDate() == LocalDate.now()) {
				Customer customer = new Customer.Builder(changes.getCustomerID(), changes.getSSN())
												.setFirstName(changes.getFirstName())
												.setSurName(changes.getSurName())
												.setAddress(changes.getAddress())
												.setCountry(changes.getCountry())
												.setZipCode(changes.getZipCode())
												.setCity(changes.getCity())
												.setEmail(changes.getEmail())
												.setPhoneNumber(changes.getPhoneNumber())
												.build();
				cb.update(customer);
			}
		}
		
	}
	
	public void create(CustomerChanges customer) {
    	Optional<CustomerChanges> optional = read(customer.getCustomerID());
    	
    	if(optional.isPresent())
    		update(customer);
    	else
    		em.persist(new CustomerChangesEntity(customer));
    }
	
	public Optional<CustomerChanges> read(int customerID){
    	CustomerChangesEntity entity = em.find(CustomerChangesEntity.class, customerID);
    	if(entity != null) 
    		return Optional.of(entity.toDomain());
    	else 
    			return Optional.empty();
    }
    
    public void update(CustomerChanges customer) {
    	CustomerChangesEntity entity = em.find(CustomerChangesEntity.class, customer.getCustomerID());
    	if(entity != null) {
    		entity.setFirstName(customer.getFirstName());
    		entity.setSurName(customer.getSurName());
    		entity.setAddress(customer.getAddress());
    		entity.setCountry(customer.getCountry());
    		entity.setZipCode(customer.getZipCode());
    		entity.setCity(customer.getCity());
    		entity.setEmail(customer.getEmail());
    		entity.setChangeDate(customer.getChangeDate());
    	}
    	else 
    		throw new CustomerNotFoundException();
    }
    
    public void delete(int customerID) {
    	CustomerChangesEntity entity = em.find(CustomerChangesEntity.class, customerID);
    	
    	if(entity != null)
    		em.remove(entity);
    	else
    		throw new CustomerNotFoundException();
    }
    
	
    public List<CustomerChanges> list(String ssn){
    	return em.createNamedQuery("searchCustomesChanges", CustomerChangesEntity.class)
    				.setParameter("ssn", ssn)
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    				
    }

}
