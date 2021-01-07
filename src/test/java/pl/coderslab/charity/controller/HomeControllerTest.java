package pl.coderslab.charity.controller;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@DisplayName("Processing create home request")
@WebMvcTest(controllers = HomeController.class)
class HomeControllerTest {

    @MockBean
    InstitutionService is;

    @MockBean
    CategoryService cs;

    @MockBean
    DonationService ds;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("- my first test... will see")
    void test1() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));


    }

}