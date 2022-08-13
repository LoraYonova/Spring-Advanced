package com.example.plants.web;

import com.example.plants.model.DTO.UserRegisterDTO;
import com.example.plants.model.validation.UniqueUsernameValidator;
import com.example.plants.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerMockMvcTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService user;

    @MockBean
    private UserRegisterDTO userRegisterDTO;

    @BeforeEach
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new RegisterController(user))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void registerControllerStatus() throws Exception{
        this.mockMvc.perform(get("/users/register")).andExpect(status().isOk())
                .andExpect(view().name("register")).andDo(print());
    }

    @Test
    public void registerControllerStatusOnWhenOk() throws Exception{

        this.mockMvc.perform(post("/users/register")
                        .param("username", "moni")
                        .param("firstName","Monica")
                        .param("lastName", "Angelova")
                        .param("email", "moni@gmail.com")
                        .param("password", "123456")
                        .param("confirmPassword", "123456"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

    }

}
