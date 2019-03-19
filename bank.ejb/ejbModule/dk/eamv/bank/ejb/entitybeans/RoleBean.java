package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.ejb.entity.RoleEntity;
import dk.eamv.bank.ejb.exception.RoleAlreadyExistsException;
import dk.eamv.bank.ejb.exception.RoleNotFoundException;

/**
 * Session Bean implementation class RoleBean
 */
@Stateless
@LocalBean
public class RoleBean {
	@PersistenceContext private EntityManager em;

    /**
     * Default constructor. 
     */
    public RoleBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void create(Role role) {
    	Optional<Role> optional = read(role.getRoleID());
    	
    	if(optional.isPresent())
    		throw new RoleAlreadyExistsException();
    	else
    		em.persist(new RoleEntity(role));
    }
    
    public Optional<Role> read(int roleID){
    	RoleEntity entity = em.find(RoleEntity.class, roleID);
    	if(entity != null) 
    		return Optional.of(entity.toDomain());
    	else 
    			return Optional.empty();
    }
    
    public void delete(int roleID) {
    	RoleEntity entity = em.find(RoleEntity.class, roleID);
    	
    	if(entity != null)
    		em.remove(entity);
    	else
    		throw new RoleNotFoundException();
    }
    
    public List<Role> list(){
    	return em.createNamedQuery("allRoles", RoleEntity.class)
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    }
    
    public List<Role> namedList(String search){
    	return em.createNamedQuery("searchRole", RoleEntity.class)
    				.setParameter("search", "%" + search + "%")
    				.getResultList()
    				.stream()
    				.map(c -> c.toDomain())
    				.collect(Collectors.toList());
    }

}
