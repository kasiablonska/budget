package pl.sda.budget.domain;

import lombok.*;

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
    private String typeOfExpense;
}
