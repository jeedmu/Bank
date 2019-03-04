package dk.eamv.bank.ejb.entitybeans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.ejb.entity.CustomerEntity;;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@LocalBean
public class CustomerBean {
	@PersistenceContext private EntityManager em;

	@Override
    public void create(Customer customer){
    	Optional<Customer> optional = read(customer.getCustomerID());
    	
    	if(optional.isPresent())
    		throw new CustomerAlreadyExsistsException();
    	else
    		em.persist(new CustomerEntity(customer));
    }
    @Override
    public Optional<Customer> read(int customerID){
    	CustomerEntity entity = em.find(CustomerEntity.class, customerID);
    	if(entity != null) 
    		return Optional.of(entity.toDomain());
    	else 
    			return Optional.empty();
    }
    
    @Override
    public void update(Customer customer) {
    	CustomerEntity entity = em.find(CustomerEntity.class, customer.getCustomerID());
    	if(entity != null) {
    		entity.setFirstName(customer.getFirstName());
    		entity.setSurName(customer.getSurName());
    		entity.setAddress(customer.getAddress());
    		entity.setCountry(customer.getCountry());
    		entity.setZipCode(customer.getZipCode());
    		entity.setCity(customer.getCity());
    		entity.setEmail(customer.getEmail());
    	}
    	else 
    		throw new CustomerNotFoundException();
    }
    
    @Override
    public void delete(int customerID) {
    	CustomerEntity entity = em.find(CustomerEntity.class, customerID);
    }

}