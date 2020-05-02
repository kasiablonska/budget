package pl.sda.budget.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateExpense {
    private Integer id;
    private String typeOfExpense;
}
