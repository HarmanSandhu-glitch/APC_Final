package com.project.pms.expenseservice.controller;

import com.project.pms.expenseservice.entity.Expense;
import com.project.pms.expenseservice.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> submitExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.saveExpense(expense));
    }
}