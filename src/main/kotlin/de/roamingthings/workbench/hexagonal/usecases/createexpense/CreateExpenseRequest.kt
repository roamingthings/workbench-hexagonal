package de.roamingthings.workbench.hexagonal.usecases.createexpense

import javax.validation.constraints.NotBlank

data class CreateExpenseRequest(
        @NotBlank
        val description: String
)