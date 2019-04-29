package dk.eamv.bank.ejb.entitybeans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.ejb.entity.UserEntity;
import dk.eamv.bank.ejb.entity.ZipCodeEntity;
import dk.eamv.bank.ejb.exception.ZipCodeAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.ZipCodeNotFoundException;

/**
 * Session Bean implementation class ZipCodeBean
 */
@Stateless
@LocalBean
public class ZipCodeBean {
	@PersistenceContext private EntityManager em;

    /**
     * Default constructor. 
     */
    public ZipCodeBean() {
        // TODO Auto-generated constructor stub
    }

    public ZipCodeEntity create(ZipCodeEntity zip) {
    	Optional<ZipCodeEntity> optional = read(zip.getZipCode());
    	
    	if(optional.isPresent()) {
    		throw new ZipCodeAlreadyExsistsException();
    	}
    	else {
    		em.persist(zip);
    		return zip;
    	}
    }
    
    
    public Optional<ZipCodeEntity> read(String zip){
    	ZipCodeEntity entity = em.find(ZipCodeEntity.class, zip);
		if (entity != null)
			return Optional.of(entity);
		else
			return Optional.empty();
    }
    
    public void update(ZipCodeEntity zip) {
    	ZipCodeEntity entity = em.find(ZipCodeEntity.class, zip.getZipCode());
    	if(entity != null) {
    		entity.setZipCode(zip.getZipCode());
    		entity.setCity(zip.getCity());
    	}
    	else
    		throw new ZipCodeNotFoundException();
    }
    
    public void delete(String zip) {
    	ZipCodeEntity entity = em.find(ZipCodeEntity.class, zip);
    	
    	if(entity != null) 
    		em.remove(entity);
    	else
    		throw new ZipCodeNotFoundException();
    	
    }
}
