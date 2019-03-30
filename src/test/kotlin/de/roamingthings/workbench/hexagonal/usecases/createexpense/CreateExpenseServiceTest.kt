package de.roamingthings.workbench.hexagonal.usecases.createexpense

import de.roamingthings.workbench.hexagonal.ports.expense.ExpenseRepository
import de.roamingthings.workbench.hexagonal.test.any
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class CreateExpenseServiceTest {

    @Mock
    lateinit var expenseRepository: ExpenseRepository

    @InjectMocks
    lateinit var createExpenseService: CreateExpenseService

    @Test
    internal fun `should pass converted entity to repository`() {

        repositoryPersistsEntity()

        createExpenseService.createExpense(aCreateExpenseCommand())

        verify(expenseRepository).save(anExpenseEntityWithoutId())
    }

    @Test
    internal fun `should return converted entity`() {

        repositoryPersistsEntity()

        val expense = createExpenseService.createExpense(aCreateExpenseCommand())

        assertThat(expense).isEqualTo(anExpense())
    }

    private fun repositoryPersistsEntity() {
        doReturn(anExpenseEntityWithId())
                .`when`(expenseRepository).save(any())
    }

}
