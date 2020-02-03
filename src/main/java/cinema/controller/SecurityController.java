package cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistance.entity.Account;
import cinema.persistance.repository.AccountRepository;

@RestController
@RequestMapping("/api/login")
public class SecurityController {
	
	@Autowired
	AccountRepository accountRepository;
	
	public Account loginAction(@RequestParam("username") String username, @RequestParam("password") String password) {
		Account user = accountRepository.findByUsername(username);
		if(user != null && user.getPassword().equals(password)) {
			user.setStatus(1);
			return user;
		}
		return null;
	}
	
}
