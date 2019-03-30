package de.roamingthings.workbench.hexagonal.usecases.createexpense

import de.roamingthings.workbench.hexagonal.domain.Expense
import de.roamingthings.workbench.hexagonal.ports.expense.model.ExpenseEntity

const val ID = "839fe44f-4eae-4e86-b6d0-331740b59b4b"
const val DESCRIPTION = "Test Description"

fun anExpense() =
        Expense(
                ID,
                DESCRIPTION
        )

fun aCreateExpenseRequest() =
        CreateExpenseRequest(
                DESCRIPTION
        )

fun aCreateExpenseCommand() = CreateExpenseCommand(DESCRIPTION)
fun anExpenseEntityWithId() = ExpenseEntity(ID, DESCRIPTION)
fun anExpenseEntityWithoutId() = ExpenseEntity(description = DESCRIPTION)