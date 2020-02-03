package cinema.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistance.entity.Account;
import cinema.persistance.repository.AccountRepository;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping
 	 public Set<Account> singleAccount(@PathVariable("id") int id) {
		return null;
	}

}
