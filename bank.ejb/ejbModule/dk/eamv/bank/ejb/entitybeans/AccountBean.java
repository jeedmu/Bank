package dk.eamv.bank.ejb.entitybeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.eamv.bank.domain.Account;
import dk.eamv.bank.ejb.entity.AccountEntity;
import dk.eamv.bank.ejb.entity.AccountKey;
import dk.eamv.bank.ejb.exception.AccountAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean {
	
	@PersistenceContext private EntityManager em;

	public void create(Account account) {
		Optional<Account> optional = read(account.getRegNumber(), account.getAccountNumber());
		if (optional.isPresent()) {
			throw new AccountAlreadyExsistsException();
		} else {
			em.persist(new AccountEntity(account));
		}
	}
	
	public Optional<Account> read(int regNumber, int accountNumber){
		AccountEntity entity = em.find(AccountEntity.class, new AccountKey(regNumber, accountNumber));
		if (entity != null) {
			return Optional.of(entity.toDomain());
		} else {
			return Optional.empty();
		}
	}
	
	public void update(Account account) {
		AccountEntity entity = em.find(AccountEntity.class, new AccountKey(account.getRegNumber(), account.getAccountNumber()));
		if (entity != null) {
			entity.setAccountName(account.getAccountName());
			entity.setBalance(account.getBalance());
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	public void delete(int regNumber, int accountNumber) {
		AccountEntity entity = em.find(AccountEntity.class, new AccountKey(regNumber, accountNumber));
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	public List<Account> list(int customerID) {
		return em.createNamedQuery("searchAccounts", AccountEntity.class)
				.setParameter("customerID", "=" + customerID)
				.getResultList()
				.stream()
				.map(a -> a.toDomain())
				.collect(Collectors.toList());
}

}
