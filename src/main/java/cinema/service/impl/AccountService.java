package cinema.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cinema.persistance.entity.Account;
import cinema.persistance.repository.AccountRepository;
import cinema.persistance.repository.RoleRepository;
import cinema.service.IAccountService;

@Service
public class AccountService implements IAccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
    public void save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRoles(new HashSet<>(roleRepository.findAll()));
        accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

}
