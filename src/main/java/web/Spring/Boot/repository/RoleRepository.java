package web.Spring.Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Spring.Boot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
