package de.roamingthings.workbench.hexagonal.usecases.createexpense

import de.roamingthings.workbench.hexagonal.test.any
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.util.UriComponentsBuilder.fromUriString
import java.net.URI

@ExtendWith(MockitoExtension::class)
class CreateExpenseControllerTest {

    @Mock
    lateinit var createExpenseService: CreateExpenseService

    @InjectMocks
    lateinit var createExpenseController: CreateExpenseController

    @Test
    fun `should respond with CREATED and location of new resource`() {
        serviceReturnsPersistedExpense()

        val response = createExpenseController.createExpense(
                aCreateExpenseRequest(),
                fromUriString("http://localhost")
        )

        assertThat(response.statusCode).isEqualTo(CREATED)
        assertThat(response.headers.location).isEqualTo(URI("http://localhost/expenses/$ID"))
    }

    @Test
    fun `should pass request as command to service`() {
        serviceReturnsPersistedExpense()

        createExpenseController.createExpense(
                aCreateExpenseRequest(),
                fromUriString("http://localhost")
        )

        verify(createExpenseService).createExpense(aCreateExpenseCommand())
    }

    private fun serviceReturnsPersistedExpense() {
        doReturn(anExpense())
                .`when`(createExpenseService).createExpense(any())
    }

}
