package jaethem8.jaethem8backend.service.user;

import jaethem8.jaethem8backend.model.user.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User> getUsers();
}
