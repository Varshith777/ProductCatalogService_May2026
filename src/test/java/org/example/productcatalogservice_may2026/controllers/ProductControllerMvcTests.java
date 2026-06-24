package org.example.productcatalogservice_may2026.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productcatalogservice_may2026.dtos.ProductDto;
import org.example.productcatalogservice_may2026.models.Product;
import org.example.productcatalogservice_may2026.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTests {

    @MockBean
    private IProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    public void Test_GetProductById_WhereProductIsNotFound_ReturnsNotFoundResponse() throws Exception {
       // "/products/2"
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void Test_GetProductById_WithValidPositiveId_ReturnsProductSuccessfully() throws Exception {
        // "/products/2"
        //Arrange
        Long productId = 2L;
        Product product = new Product();
        product.setId(productId);
        product.setName("MacBook");
        when(productService.getProductById(productId)).thenReturn(product);

        ProductDto productDto  = new ProductDto();
        productDto.setId(productId);
        productDto.setName("MacBook");

        String expectedResponse = objectMapper.writeValueAsString(productDto);
        System.out.println(expectedResponse);

        mockMvc.perform(get("/products/2"))  //ACT
                .andExpect(status().isOk())    //ASSERT
                .andExpect(content().string(expectedResponse));  //ASSERT
    }
}


//{
//    "id"  :2,"name" : "MacBook"
//}