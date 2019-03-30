package de.roamingthings.workbench.hexagonal.ports.expense

import de.roamingthings.workbench.hexagonal.ports.expense.model.ExpenseEntity
import de.roamingthings.workbench.hexagonal.usecases.createexpense.ID

const val DESCRIPTION = "Expense Description"

fun anExpenseWithoutId(): ExpenseEntity =
        ExpenseEntity(description = DESCRIPTION)
