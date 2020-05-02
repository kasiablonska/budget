package pl.sda.budget.service;

import org.springframework.stereotype.Service;
import pl.sda.budget.api.model.NewExpense;
import pl.sda.budget.domain.ExpenseEntity;
import pl.sda.budget.domain.ExpenseRepository;

@Service
public class ExpenseService {

private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

public void createExpense (NewExpense newExpense){

    ExpenseEntity entity= new ExpenseEntity(null,newExpense.getTypeOfExpense());
expenseRepository.save(entity);
}
    public void deleteById(Integer id) {
        expenseRepository.deleteById(id);
    }
}
