package jaethem8.jaethem8backend.service.user;

import jaethem8.jaethem8backend.dto.user.UserDTO;
import jaethem8.jaethem8backend.model.user.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);

    User getUser(String username);

    List<User> getUsers();
}
