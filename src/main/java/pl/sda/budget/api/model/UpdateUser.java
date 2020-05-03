package pl.sda.budget.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUser {
    private Integer id;
    private String userName;
    private String password;
    private String role;
}
