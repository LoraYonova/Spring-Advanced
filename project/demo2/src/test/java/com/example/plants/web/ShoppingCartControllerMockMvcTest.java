package com.example.plants.web;

import com.example.plants.service.OrderService;
import com.example.plants.service.ProductService;
import com.example.plants.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingCartControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShoppingCartService shoppingCartService;

    @MockBean
    ProductService productService;

    @MockBean
    OrderService orderService;

    @BeforeEach
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(new ShoppingCartController(shoppingCartService, productService, orderService))
                .build();
    }

    @Test
    public void cartControllerStatus() throws Exception{
        this.mockMvc.perform(get("/myCart")).andExpect(status().isOk())
                .andExpect(view().name("shopping-cart")).andDo(print());
    }
}
