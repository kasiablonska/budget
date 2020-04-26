package pl.sda.budget.utils;

import lombok.*;
import pl.sda.budget.enums.Currency;
import pl.sda.budget.enums.Expenses;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPlan {
    private Integer id;
    private String invoiceNumber;
    private Data paymentTerm;
    private Integer invoiceAmount;
    private Currency invoiceCurrency;
    private Integer invoiceAmountInEur;
    private Expenses typeOfExpense;
}
