package de.roamingthings.workbench.hexagonal.ports.expense

import de.roamingthings.workbench.hexagonal.ports.expense.model.ExpenseEntity
import org.springframework.data.repository.CrudRepository

interface ExpenseRepository: CrudRepository<ExpenseEntity, String>
