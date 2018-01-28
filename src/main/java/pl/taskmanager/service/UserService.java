package pl.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.taskmanager.dao.UserRepository;
import pl.taskmanager.dao.UserRoleRepository;
import pl.taskmanager.model.User;
import pl.taskmanager.model.UserRole;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void addWithDefaultRole(User user) {
        UserRole defauRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defauRole);
        userRepository.save(user);
    }
}
