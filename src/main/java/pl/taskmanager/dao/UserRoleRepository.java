package pl.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.taskmanager.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(String role);
}
