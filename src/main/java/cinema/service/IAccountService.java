package cinema.service;

import cinema.dto.AccountPassword;
import cinema.persistance.entity.Account;
import cinema.service.common.IAbstractService;

public interface IAccountService extends IAbstractService<Account> {
	
	Account findByMail(String username);
	public Account changePassword(AccountPassword accountPassword);
}
