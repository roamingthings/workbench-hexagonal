package de.roamingthings.workbench.hexagonal.usecases.createexpense

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
class CreateExpenseController(
        private val createExpenseService: CreateExpenseService
) {

    @PostMapping(value = ["/expenses"], consumes = [APPLICATION_JSON_VALUE])
    fun createExpense(@Valid @RequestBody request: CreateExpenseRequest, ucBuilder: UriComponentsBuilder): ResponseEntity<Nothing> {

        val expense = createExpenseService.createExpense(CreateExpenseCommand(request.description))

        return created(ucBuilder.path("/expenses/{id}").buildAndExpand(expense.id).toUri()).build()
    }
}
