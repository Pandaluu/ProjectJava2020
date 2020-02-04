package cinema.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findByUsername (String username);
	Account findByEmail (String email);
}
