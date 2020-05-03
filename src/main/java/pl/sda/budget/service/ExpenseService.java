package pl.sda.budget.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.budget.AlreadyExistsException;
import pl.sda.budget.NotFoundException;
import pl.sda.budget.api.model.Expense;
import pl.sda.budget.api.model.NewExpense;
import pl.sda.budget.api.model.UpdateExpense;
import pl.sda.budget.domain.ExpenseEntity;
import pl.sda.budget.domain.ExpenseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void createExpense(NewExpense newExpense) {
        List<ExpenseEntity> expensesWithSameType = expenseRepository.findAllByTypeOfExpense(newExpense.getTypeOfExpense());
        if (!expensesWithSameType.isEmpty()) {
            throw new AlreadyExistsException("Expense with type " + newExpense.getTypeOfExpense() + " already exists");
        }
        ExpenseEntity entity = new ExpenseEntity(null, newExpense.getTypeOfExpense());
        expenseRepository.save(entity);
    }

    @Transactional
    public void updateExpense(UpdateExpense updateExpense) {
        ExpenseEntity expenseToUpdate = expenseRepository.findById(updateExpense.getId())
                .orElseThrow(() -> new NotFoundException("Expense with id " + updateExpense.getId() + " not exist"));

        expenseToUpdate.setTypeOfExpense(updateExpense.getTypeOfExpense());

    }

    public Optional<Expense> getById(Integer id) {
        return expenseRepository.findById(id)
                .map(ent -> new Expense(ent.getId(), ent.getTypeOfExpense()));
    }

    public List<Expense> getAll() {
        return expenseRepository.findAll().stream()
                .map(ent -> new Expense(ent.getId(), ent.getTypeOfExpense()))
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        expenseRepository.deleteById(id);
    }
}
