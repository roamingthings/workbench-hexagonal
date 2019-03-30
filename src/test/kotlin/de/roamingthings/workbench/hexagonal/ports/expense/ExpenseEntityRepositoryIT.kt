package de.roamingthings.workbench.hexagonal.ports.expense

import de.roamingthings.workbench.hexagonal.ports.expense.model.ExpenseEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ExpenseEntityRepositoryIT {

    @Autowired
    lateinit var expenseRepository: ExpenseRepository

    @Test
    fun `it should find a persisted entity`() {
        val persistedPerson = aPersistedExpense()

        val person = expenseRepository.findById(persistedPerson.id!!)

        assertThat(person.isPresent).isTrue()
        assertThat(person.get().description).isEqualTo(DESCRIPTION)
    }

    private fun aPersistedExpense(): ExpenseEntity =
            expenseRepository.save(anExpenseWithoutId())
}