package cinema.service;

import cinema.persistance.entity.Account;

public interface IAuthChecker {
	Account getCurrentUser();
}
