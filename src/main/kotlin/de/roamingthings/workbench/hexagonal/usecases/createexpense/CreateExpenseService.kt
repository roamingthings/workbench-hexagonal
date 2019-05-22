package de.roamingthings.workbench.hexagonal.usecases.createexpense

import de.roamingthings.workbench.hexagonal.domain.Expense
import de.roamingthings.workbench.hexagonal.ports.expense.ExpenseRepository
import de.roamingthings.workbench.hexagonal.ports.expense.model.toExpense
import de.roamingthings.workbench.hexagonal.ports.expense.model.toExpenseEntity
import org.springframework.stereotype.Service

data class CreateExpenseCommand(val description: String)

@Service
class CreateExpenseService(
        private val expenseRepository: ExpenseRepository
) {

    fun createExpense(command: CreateExpenseCommand): Expense {
        return expenseRepository.save(command.toExpenseEntity()).toExpense()
    }
}
