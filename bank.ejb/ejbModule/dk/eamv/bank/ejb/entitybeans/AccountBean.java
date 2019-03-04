package dk.eamv.bank.ejb.entitybeans;

import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.ejb.entity.AccountEntity;
import ejbModule.javaee.ejb.beans.Property;
import ejbModule.javaee.ejb.beans.PropertyAlreadyExistsException;
import ejbModule.javaee.ejb.beans.PropertyEntity;
import ejbModule.javaee.ejb.beans.PropertyNotFoundException;
import ejbModule.javaee.ejb.beans.String;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean {
	
	@PersistenceContext private EntityManager em;

	public void create(Account account) throws AccountAlreadyExsistsException {
		Optional<Account> optional = read(account.getAccountNumber());
		if (optional.isPresent()) {
			throw new AccountAlreadyExsistsException();
		} else {
			em.persist(new AccountEntity(account));
		}
	}
	
	public Optional<Account> read(int accountNumber){
		AccountEntity entity = em.find(AccountEntity.class, accountNumber);
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Account account) {
		AccountEntity entity = em.find(AccountEntity.class, account.getAccountNumber());
		if (entity != null) {
			entity.setRegNumber(account.getRegNumber());
			entity.setAccountNumber(account.getAccountNumber());
			entity.setAccountName(account.getAccountName());
			entity.setBalance(account.getBalance());
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	public void delete(int accountNumber) throws AccountNotFoundException {
		AccountEntity entity = em.find(AccountEntity.class, accountNumber);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	public List<Account> list(String search) {
		return em.createNamedQuery("searchAccounts", AccountEntity.class)
				.setParameter("search", "%" + search.toUpperCase() + "%")
				.getResultList()
				.stream()
				.map(p -> p.toDomain())
				.collect(Collectors.toList());
}
	

}
