package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @InjectMocks
    private ProductController controller;

    @Mock
    ProductServiceImpl service;


    Model model = mock(Model.class);
    Product product = new Product();

    @BeforeEach
    void setUp(){
        product.setProductId("siBambang");
        product.setProductName("Bambanggg");
        product.setProductQuantity(2);
    }
    @AfterEach
    void clear(){
        controller.delete(model, "siBambang");
    }

    @Test
    void testCreateProductPage(){
        String result = controller.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void testCreateProductPost(){
        String result = controller.createProductPost(product, model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testProductListPage(){
        String result = controller.productListPage(model);
        assertEquals("ProductList", result);
    }

    @Test
    void testEditProductPage(){
        String result = controller.editProductPage(model, product.getProductId());
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPost(){
        Product editedProduct = new Product();
        editedProduct.setProductId("siBambang");
        editedProduct.setProductName("Bambanggg ganti");
        editedProduct.setProductQuantity(3);
        String result = controller.editProductPost(editedProduct, model, product.getProductId());
        assertEquals("redirect:../list", result);
    }

    @Test
    void testDeletePage(){
        String result = controller.delete(model, product.getProductId());
        assertEquals("redirect:../list", result);
    }


    @Test
    void testHomePage(){
        String result = controller.homePage(model);
        assertEquals("Home", result);
    }

}