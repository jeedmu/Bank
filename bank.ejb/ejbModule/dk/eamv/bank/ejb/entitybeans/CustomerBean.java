package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.ejb.entity.CustomerEntity;
import dk.eamv.bank.ejb.exception.CustomerAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@LocalBean
public class CustomerBean {
	@PersistenceContext private EntityManager em;

	public void create(Customer customer) {
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
    
    public void delete(int customerID) {
    	CustomerEntity entity = em.find(CustomerEntity.class, customerID);
    	
    	if(entity != null)
    		em.remove(entity);
    	else
    		throw new CustomerNotFoundException();
    }
    
    public List<Customer> list(){
    	return em.createNamedQuery("AllCustomers", CustomerEntity.class)
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    				
    }
    
    public List<Customer> namedList(String search){
    	return em.createNamedQuery("SearchCustomer", CustomerEntity.class)
    				.setParameter("search", "%" + search + "%")
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    				
    }
    
    public List<Customer> getCustomers(CustomerSearchParameters para){
    	TypedQuery<CustomerEntity> createNamedQuery = em.createNamedQuery("SearchCustomer", CustomerEntity.class);
    	
    	if(para.getSsn() != null) 
    		createNamedQuery.setParameter("ssn", "%" + para.getSsn() + "%"); 
    	
    	if (para.getFirstName() != null) 
    		createNamedQuery.setParameter("firstName", "%" + para.getFirstName() + "%");
    	
    	if (para.getLastName() != null) 
    		createNamedQuery.setParameter("lastName", "%" + para.getLastName() + "%");
    	
    	if (para.getAddress() != null) 
    		createNamedQuery.setParameter("address", "%" + para.getAddress() + "%");
    	
    	if (para.getEmail() != null) 
    		createNamedQuery.setParameter("email", "%" + para.getEmail() + "%");
    	
    	if (para.getPhoneNumber() != null) 
    		createNamedQuery.setParameter("phoneNumber", "%" + para.getPhoneNumber() + "%");
    	   	
    	return createNamedQuery    				
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());    				
    }

}
