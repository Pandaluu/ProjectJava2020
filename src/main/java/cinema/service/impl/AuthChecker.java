package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cinema.exeption.NotAuthorizedException;
import cinema.persistance.entity.Account;
import cinema.service.IAuthChecker;
import cinema.service.ICleanerService;
import cinema.service.IAccountService;

@Component
public class AuthChecker implements IAuthChecker {

	@Autowired
	private IAccountService userService;
	
	@Override
	public Account getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails ud = (UserDetails)principal;
			return userService.findByMail(ud.getUsername());
		} else {
			throw new NotAuthorizedException("NO CURRENT USER");
		}
	}
}
