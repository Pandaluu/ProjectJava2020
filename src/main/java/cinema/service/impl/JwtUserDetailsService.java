package cinema.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cinema.service.ICleanerService;
import cinema.persistance.entity.Account;
import cinema.service.IAccountService;
import cinema.service.IJwtUserDetailsService;

public class JwtUserDetailsService implements IJwtUserDetailsService {
	@Autowired
	private IAccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		/**
		 * I get a Client from the info I got from outside
		 */
		Account a = accountService.findByMail(username);
		
		/**
		 * If I do find a Client in my DB with it, I return it:
		 */
		
		if (a != null) {
			return new Account(a.getEmail(), a.getPassword(), new ArrayList<>());
		} else {			
			/**
			 * If I didn't find any corresponding User (client or Cleaner, I return an exception:
			 */
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
