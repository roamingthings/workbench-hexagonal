package de.roamingthings.workbench.hexagonal.ports.expense

import de.roamingthings.workbench.hexagonal.ports.expense.model.ExpenseEntity
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent
import java.util.UUID.randomUUID


@Configuration
class ExpenseJdbcConfiguration {

    @Bean
    fun idInitialization(): ApplicationListener<BeforeSaveEvent> {

        return ApplicationListener { event ->

            val entity = event.entity
            if (entity is ExpenseEntity) {
                entity.id = randomUUID().toString()
            }
        }
    }
}