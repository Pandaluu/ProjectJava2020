package cinema.persistance.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Set<Account> findByUserName(String username);
	Set<Account> findByFirstName(String firstname);
	Set<Account> findByLastName(String lastname);
	

}
