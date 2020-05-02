package pl.sda.budget.domain;

import lombok.*;
import pl.sda.budget.api.model.enums.Expenses;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Expense")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Expenses typeOfExpense;
}
