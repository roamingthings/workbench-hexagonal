package de.roamingthings.workbench.hexagonal.ports.expense.model

import de.roamingthings.workbench.hexagonal.domain.Expense
import de.roamingthings.workbench.hexagonal.usecases.createexpense.CreateExpenseCommand
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Table("EXPENSE")
data class ExpenseEntity(
        @Id
        var id: String? = null,

        @NotBlank
        @Size(max = 255)
        val description: String
)

fun ExpenseEntity.toExpense() =
        Expense(
                this.id,
                this.description
        )


fun CreateExpenseCommand.toExpenseEntity() =
        ExpenseEntity(
                null,
                this.description
        )
