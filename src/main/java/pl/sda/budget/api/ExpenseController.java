package pl.sda.budget.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.budget.api.model.NewExpense;
import pl.sda.budget.service.ExpenseService;

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
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteExpense(@PathVariable Integer id) {
        expenseService.deleteById(id);
    }
}