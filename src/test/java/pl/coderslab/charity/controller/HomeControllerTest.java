package pl.coderslab.charity.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.coderslab.charity.app.CustomAuthenticationSuccessHandler;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.CustomerUserDetailsService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@DisplayName("Processing create home request")
@WebMvcTest(controllers = HomeController.class)
class HomeControllerTest {

    @MockBean
    CustomerUserDetailsService cuds;

    @MockBean
    CustomAuthenticationSuccessHandler cash;

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



//    @Test
//    @DisplayName("- when sent create donation request should proceed with success")
//    void test2() throws Exception {
//        mockMvc
//                .perform(MockMvcRequestBuilders.post("/give-donation")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param("quantity", "1")
//                        .param("pickupDate", "2020-12-20")
//                        .param("institution", "1")
//                )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("donation/confirmation"))
//                .andExpect(MockMvcResultMatchers.model().attributeExists("donation"));
//    }

}