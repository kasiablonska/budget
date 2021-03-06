package pl.sda.budget.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewUser {

    private String userName;
    private String password;
    private String role;

}
