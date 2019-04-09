package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Property;
import dk.eamv.bank.ejb.entity.PropertyEntity;
import dk.eamv.bank.ejb.exception.PropertyAlreadyExistsException;
import dk.eamv.bank.ejb.exception.PropertyNotFoundException;

/**
 * Session Bean implementation class PropertyBean
 */
@Stateless
@LocalBean
public class PropertyBean {
	@PersistenceContext
	private EntityManager em;

	public void create(Property property) {
		Optional<Property> optional = read(property.getProperty());
		if (optional.isPresent()) {
			throw new PropertyAlreadyExistsException();
		} else {
			em.persist(new PropertyEntity(property));
		}

	}

	public Optional<Property> read(String property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}

	public void update(Property property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property.getProperty());
		if (entity != null) {
			entity.setValue(property.getValue());
		} else {
			throw new PropertyNotFoundException();
		}
	}

	public void delete(String property) {
		PropertyEntity entity = em.find(PropertyEntity.class, property);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new PropertyNotFoundException();
		}
	}

	public List<Property> getProperties() {
		return em.createNamedQuery("allProperties", PropertyEntity.class)
				.getResultList()
				.stream()
				.map(p -> p.toDomain())
				.collect(Collectors.toList());

	}

}
