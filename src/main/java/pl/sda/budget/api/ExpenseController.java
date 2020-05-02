package pl.sda.budget.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.budget.api.model.Expense;
import pl.sda.budget.api.model.NewExpense;
import pl.sda.budget.api.model.UpdateExpense;
import pl.sda.budget.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    ResponseEntity<Void> expense(@RequestBody NewExpense newExpense) {
        expenseService.createExpense(newExpense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    void updateExpense(@RequestBody UpdateExpense updateExpense) {
        expenseService.updateExpense(updateExpense);
    }

    @GetMapping
    List<Expense> getAll() {
        return expenseService.getAll();
    }
    @GetMapping("/{id}")
    Expense getById(@PathVariable Integer id) {
        return expenseService.getById(id).get();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteExpense(@PathVariable Integer id) {
        expenseService.deleteById(id);
    }
}