package pl.sda.budget.api.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    private Integer id;
    private String typeOfExpense;
}
