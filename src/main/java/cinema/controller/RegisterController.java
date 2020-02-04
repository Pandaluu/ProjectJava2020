package cinema.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import cinema.dto.AccountDto;

public class RegisterController {

	@GetMapping(value = "/api/register")
	public String userRegister(WebRequest request, Model model) {
	    AccountDto accountDto = new AccountDto();
	    model.addAttribute("user", accountDto);
	    return "registration";
	}
}
