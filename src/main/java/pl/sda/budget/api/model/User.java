package pl.sda.budget.api.model;

import lombok.*;
import pl.sda.budget.api.model.enums.Roles;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Roles role;
}
