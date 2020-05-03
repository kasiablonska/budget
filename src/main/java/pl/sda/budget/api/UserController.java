package pl.sda.budget.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.budget.api.model.NewUser;
import pl.sda.budget.domain.UserEntity;
import pl.sda.budget.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    UserEntity<Void> user (@RequestBody NewUser newUser){
        userService.createUser(newUser);
        return UserEntity.status(HttpStatus.CREATED).build();
    }
}
