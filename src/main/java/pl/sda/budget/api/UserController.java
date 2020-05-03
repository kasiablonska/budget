package pl.sda.budget.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.budget.api.model.NewUser;
import pl.sda.budget.api.model.UpdateUser;
import pl.sda.budget.domain.UserEntity;
import pl.sda.budget.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    ResponseEntity<Void> user (@RequestBody NewUser newUser){
        userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    void updateUser(@RequestBody UpdateUser updateUser){
        userService.updateUser(updateUser);
    }
}
