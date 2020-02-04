package cinema.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cinema.persistance.entity.Account;
import cinema.service.impl.AccountService;

@Component
public class AccountValidator {
	
	@Autowired
	AccountService accountService;
	
	public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }
	
	public void validate(Object o, Errors errors) {
        Account a = (Account) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (a.getUsername().length() < 6 || a.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (accountService.findByUsername(a.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (a.getPassword().length() < 8 || a.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!a.getPasswordConfirm().equals(a.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
