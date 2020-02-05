package cinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cinema.persistance.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM account WHERE username = ?1 LIMIT 0,1")
	Account findByUsername(String username);
}
