package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public void create(Customer customer) throws CustomerAlreadyExsistsException{
    	Optional<Customer> optional = read(customer.getCustomerID());
    	
    	if(optional.isPresent())
    		throw new CustomerAlreadyExsistsException();
    	else
    		em.persist(new CustomerEntity(customer));
    }
	public Optional<Customer> read(int customerID){
    	CustomerEntity entity = em.find(CustomerEntity.class, customerID);
    	if(entity != null) 
    		return Optional.of(entity.toDomain());
    	else 
    			return Optional.empty();
    }
    
    public void update(Customer customer) throws CustomerNotFoundException {
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
    
    public void delete(int customerID) throws CustomerNotFoundException {
    	CustomerEntity entity = em.find(CustomerEntity.class, customerID);
    	
    	if(entity != null)
    		em.remove(entity);
    	else
    		throw new CustomerNotFoundException();
    }
    
    public List<Customer> list(String search){
    	return em.createNamedQuery("searchCustomers", CustomerEntity.class)
    				.setParameter("search", "%" + search.toUpperCase() + "%")
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    				
    }

}
