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
import dk.eamv.bank.ejb.exception.AccountAlreadyExsistsException;
import dk.eamv.bank.ejb.exception.AccountNotFoundException;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean {
	@PersistenceContext private EntityManager em;

	public Account create(Account account) {
		Optional<Account> optional = read(account.getAccountNumber());
		if (optional.isPresent()) {
			throw new AccountAlreadyExsistsException();
		} else {
			AccountEntity accountEntity = new AccountEntity(account);
			em.persist(accountEntity);
			return accountEntity.toDomain();
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
			entity.setAccountName(account.getAccountName());
			entity.setBalance(account.getBalance());
			em.persist(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	public void delete(int regNumber, int accountNumber) {
		AccountEntity entity = em.find(AccountEntity.class, accountNumber);
		if (entity != null) {
			em.remove(entity);
		} else {
			throw new AccountNotFoundException();
		}
	}
	public List<Account> list(int customerID) {
		return em.createNamedQuery("searchAccounts", AccountEntity.class)
				.setParameter("customerID", customerID)
				.getResultList()
				.stream()
				.map(a -> a.toDomain())
				.collect(Collectors.toList());
}

}
