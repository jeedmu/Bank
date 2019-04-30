package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dk.eamv.bank.domain.Customer;
import dk.eamv.bank.domain.CustomerSearchParameters;
import dk.eamv.bank.ejb.entity.CustomerEntity;
import dk.eamv.bank.ejb.entity.ZipCodeEntity;
import dk.eamv.bank.ejb.exception.CustomerAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.CustomerNotFoundException;
import dk.eamv.bank.ejb.exception.SSNAlreadyInUseException;;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
@LocalBean
public class CustomerBean {
	@PersistenceContext private EntityManager em;
	@EJB ZipCodeBean zCB;

	public Customer create(Customer customer) {
    	Optional<Customer> optional = read(customer.getCustomerID());
    	
    	if(optional.isPresent())
    		throw new CustomerAlreadyExsistsException();
    	else
    	{
    		if(isUserWithSsnRegistered(customer.getSSN()))
    			throw new SSNAlreadyInUseException(); 
    			
    		CustomerEntity customerEnt = new CustomerEntity(customer); 
    		em.persist(customerEnt);
    		return customerEnt.toDomain();
    	}
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
    		Optional<ZipCodeEntity> zipCode = zCB.read(customer.getZipCode());
    		ZipCodeEntity zipEntity = null;
    		if(zipCode.isEmpty()) {
    			zipEntity = new ZipCodeEntity(customer.getZipCode(), customer.getCity());
    			zCB.create(zipEntity);
    		}
    		else {
    			zipEntity = zipCode.get();
    		}
    		entity.setFirstName(customer.getFirstName());
    		entity.setSurName(customer.getSurName());
    		entity.setAddress(customer.getAddress());
    		entity.setCountry(customer.getCountry());
    		entity.setZipCode(zipEntity);
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
    
    private boolean isUserWithSsnRegistered(String ssn)
    {
    	CustomerSearchParameters params = new CustomerSearchParameters();
    	params.setSSN(ssn);
    	
    	return getCustomers(params).size() > 0;
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
    	TypedQuery<CustomerEntity> createNamedQuery = em.createQuery(" select c from customer c where c.sSN LIKE :ssn AND "
    																								+ "c.firstName LIKE :firstName AND "
    																								+ "c.surName LIKE :lastName AND "
    																								+ "c.address LIKE :address AND "
    																								+ "c.email LIKE :email AND "
    																								+ "c.phoneNumber LIKE :phoneNumber", CustomerEntity.class);
    	
    	if(para.getSSN() != null) 
    		createNamedQuery.setParameter("ssn", "%" + para.getSSN() + "%");
    	else
    		createNamedQuery.setParameter("ssn", "%" + "" + "%");
    	
    	if (para.getFirstName() != null) 
    		createNamedQuery.setParameter("firstName", "%" + para.getFirstName() + "%");
    	else
    		createNamedQuery.setParameter("firstName", "%" + "" + "%");
    	
    	if (para.getLastName() != null) 
    		createNamedQuery.setParameter("lastName", "%" + para.getLastName() + "%");
    	else
    		createNamedQuery.setParameter("lastName", "%" + "" + "%");
    	
    	if (para.getAddress() != null) 
    		createNamedQuery.setParameter("address", "%" + para.getAddress() + "%");
    	else
    		createNamedQuery.setParameter("address", "%" + "" + "%");
    	
    	if (para.getEmail() != null) 
    		createNamedQuery.setParameter("email", "%" + para.getEmail() + "%");
    	else
    		createNamedQuery.setParameter("email", "%" + "" + "%");
    	
    	if (para.getPhoneNumber() != null) 
    		createNamedQuery.setParameter("phoneNumber", "%" + para.getPhoneNumber() + "%");
    	else
    		createNamedQuery.setParameter("phoneNumber", "%" + "" + "%");
    	   	
    	return createNamedQuery  				
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());    				
    }
}
