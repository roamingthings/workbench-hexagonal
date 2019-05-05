package de.roamingthings.workbench.hexagonal.usecases.createexpense

import org.hamcrest.Matchers.startsWith
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CreateExpenseIT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    internal fun `should create expense`() {

        val requestResponse = mockMvc.perform(post("http://localhost/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """{
                          "description": "Lorem Ipsum Description"
                       }""".trimIndent())
        )

        requestResponse.andExpect(status().isCreated)
                .andExpect(header().string("Location", startsWith("http://localhost/expenses/")))
    }
}
