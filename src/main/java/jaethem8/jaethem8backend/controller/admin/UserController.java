package jaethem8.jaethem8backend.controller.admin;

import jaethem8.jaethem8backend.dto.user.UserDTO;
import jaethem8.jaethem8backend.model.user.User;
import jaethem8.jaethem8backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}

