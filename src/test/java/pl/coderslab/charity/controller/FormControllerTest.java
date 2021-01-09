package pl.coderslab.charity.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.charity.app.CustomAuthenticationSuccessHandler;
import pl.coderslab.charity.service.CustomerUserDetailsService;
import pl.coderslab.charity.service.DonationService;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Processing create home request")
@WebMvcTest(controllers = FormController.class)
class FormControllerTest {

    @MockBean
    CustomerUserDetailsService cuds;

    @MockBean
    CustomAuthenticationSuccessHandler cash;

    @MockBean
    DonationService ds;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("- when sent create donation request should proceed with success")
    void test2() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/form")
                        .with(SecurityMockMvcRequestPostProcessors.user("dupa"))
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("quantity", "1")
                        .param("pickupDate", "20-12-2020")
                        .param("institution", "1")
                        .param("category", "1", "2")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("form"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("donation", "categories", "institution"));
    }
}