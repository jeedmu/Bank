package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.entity.UserEntity;
import dk.eamv.bank.ejb.exception.UserAlreadyExistsException;
import dk.eamv.bank.ejb.exception.UserNotFoundException;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanLocal {
	@PersistenceContext
	private EntityManager em;

	public User create(User user) {
		Optional<User> optional = read(user.getUserId());

		if (optional.isPresent())
			throw new UserAlreadyExistsException();
		else {
			UserEntity entity = new UserEntity(user);
			em.persist(entity);
			return entity.toDomain();
		}
	}

	public Optional<User> read(String userId) {
		UserEntity entity = em.find(UserEntity.class, userId);
		if (entity != null)
			return Optional.of(entity.toDomain());
		else
			return Optional.empty();
	}

	public void update(User user) {
		UserEntity entity = em.find(UserEntity.class, user.getUserId());
		if (entity != null) {
			entity.setUserId(user.getUserId());
			entity.setName(user.getName());
			entity.setPassword(user.getPassword());
		} else
			throw new UserNotFoundException();
	}

	public void delete(String userId) {
		UserEntity entity = em.find(UserEntity.class, userId);

		if (entity != null)
			em.remove(entity);
		else
			throw new UserNotFoundException();
	}

	public List<User> list() {
		return em.createNamedQuery("allUsers", UserEntity.class).getResultList().stream().map(c -> c.toDomain())
				.collect(Collectors.toList());
	}

	public List<User> namedList(String search) {
		return em.createNamedQuery("searchUser", UserEntity.class).setParameter("search", "%" + search + "%")
				.getResultList().stream().map(c -> c.toDomain()).collect(Collectors.toList());
	}

}
