package pl.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.taskmanager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
