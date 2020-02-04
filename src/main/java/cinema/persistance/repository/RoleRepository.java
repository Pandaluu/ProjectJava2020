package cinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
