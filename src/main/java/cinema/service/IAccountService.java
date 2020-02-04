package cinema.service;

import cinema.persistance.entity.Account;

public interface IAccountService {
	void save(Account account);
    Account findByUsername(String username);
}
