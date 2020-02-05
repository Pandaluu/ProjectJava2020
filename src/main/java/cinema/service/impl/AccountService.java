package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import cinema.dto.AccountPassword;
import cinema.exeption.AlreadyExistException;
import cinema.persistance.entity.Account;
import cinema.persistance.repository.AccountRepository;
import cinema.service.IAccountService;
import cinema.service.common.AbstractService;

public class AccountService extends AbstractService<Account> implements IAccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public JpaRepository<Account, Long> getRepo() {
		// TODO Auto-generated method stub
		return accountRepository;
	}
	
	@Override
	public Account changePassword(AccountPassword clientPassword) {
		Account c = accountRepository.getOne(clientPassword.getId());	
		c.setPassword(clientPassword.getPassword());
		return accountRepository.save(c);
	}

	@Override
	public Account findByMail(String username) {
		return accountRepository.findByEmail(username);
	}

	@Override
	public Account save(Account t) {
		try {
			t = super.save(t);
		} catch (Exception e) {
		
			throw new AlreadyExistException("Impossible d'utiliser ces credentials");
		}
		
		return t;
	}
}
