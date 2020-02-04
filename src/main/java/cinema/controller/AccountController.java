package cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cinema.persistance.entity.Account;
import cinema.service.impl.AccountService;
import cinema.service.impl.SecurityService;
import cinema.validator.AccountValidator;

public class AccountController {
	
	@Autowired
	AccountValidator accountValidator;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new Account());
		return "registration";
	}

	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") Account accountForm, BindingResult bindingResult, Model model) {
		accountValidator.validate(accountForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		accountService.save(accountForm);
		securityService.autologin(accountForm.getUsername(), accountForm.getPasswordConfirm());
		return "redirect:/welcome";
	}

	@GetMapping(value = "/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping(value = {"/", "/welcome"})
	public String welcome(Model model) {
		return "welcome";
	}
}
