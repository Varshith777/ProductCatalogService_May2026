package org.example.productcatalogservice_may2026.controllers;

import org.apache.coyote.Response;
import org.example.productcatalogservice_may2026.dtos.ProductDto;
import org.example.productcatalogservice_may2026.models.Product;
import org.example.productcatalogservice_may2026.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    //@Autowired
    @MockBean
    private IProductService productService;


    @Test
    public void Test_GetProductById_WithPositiveId_ReturnsProductSuccessfully() {
        //Arrange
        Long productId = 2L;
        Product product = new Product();
        product.setId(productId);
        product.setName("Iphone 18");
        when(productService.getProductById(productId)).thenReturn(product);

        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductById(productId);

        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNotNull(productDtoResponseEntity.getBody());
        assertEquals(productId,productDtoResponseEntity.getBody().getId());
        assertEquals("Iphone 18",productDtoResponseEntity.getBody().getName());
    }


    //@Test
    public void Test_GetProductById_WithNegativeId_ReturnsNullProduct() {
        //Arrange
        Long productId = -2L;

        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductById(productId);

        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNull(productDtoResponseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, productDtoResponseEntity.getStatusCode());
    }

    @Test
    public void Test_GetProductById_WithNegativeId_ResultsInIllegalArgumentException()
    {
        //Arrange
        Long productId = -2L;

        //Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()->productController.getProductById(productId));

        assertEquals("Please pass positive productId",
                exception.getMessage());
    }


    @Test
    public void Test_GetProductById_WhereProductServiceReturnsNullProductAndWeReturnSame() {
        //Arrange
        Long productId = 2L;
        when(productService.getProductById(productId)).thenReturn(null);

        //Act
        ResponseEntity<ProductDto> productDtoResponseEntity =
                productController.getProductById(productId);

        //Assert
        assertNotNull(productDtoResponseEntity);
        assertNull(productDtoResponseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND,productDtoResponseEntity.getStatusCode());
    }




}