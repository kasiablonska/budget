package pl.sda.budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.budget.AlreadyExistsException;
import pl.sda.budget.NotFoundException;
import pl.sda.budget.api.model.NewUser;
import pl.sda.budget.api.model.UpdateUser;
import pl.sda.budget.domain.UserEntity;
import pl.sda.budget.domain.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(NewUser newUser) {
        List<UserEntity> usersWithSameUserName = userRepository.findAllByUserName(newUser.getUserName());
        if (!usersWithSameUserName.isEmpty()) {
            throw new AlreadyExistsException("User with user name " + newUser.getUserName() + " already exists");
        } else {
            UserEntity entity = new UserEntity(null, newUser.getUserName(), newUser.getPassword(), newUser.getRole());
            userRepository.save(entity);
        }
    }
@Transactional
    public void updateUser(UpdateUser updateUser){
UserEntity userToUpdate = userRepository.findById(updateUser.getId())
        .orElseThrow(() -> new NotFoundException("User with ID "+updateUser.getId()+" not exist"));

userToUpdate.setPassword(updateUser.getPassword());
userToUpdate.setUserName(updateUser.getUserName());
userToUpdate.setRole(updateUser.getRole());
    }
}

