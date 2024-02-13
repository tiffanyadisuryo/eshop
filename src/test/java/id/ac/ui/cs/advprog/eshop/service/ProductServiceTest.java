package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    ProductServiceImpl service;

    @BeforeEach
    void setUp(){
    }

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        service.create(product);

        List<Product> productIterator = service.findAll();
        Product savedProduct = productIterator.getFirst();
        assertEquals(savedProduct.getProductId(),"eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertEquals(savedProduct.getProductName(), "Sampo Cap Bambang");
        assertEquals(savedProduct.getProductQuantity(), 100);
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        service.create(product);

        Product editedProduct = new Product();
        editedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editedProduct.setProductName("Sambal Cap Bambambam");
        editedProduct.setProductQuantity(200);
        service.edit(editedProduct);

        List<Product> productIterator = service.findAll();
        Product savedProduct = productIterator.getFirst();
        assertEquals(savedProduct.getProductId(), editedProduct.getProductId());
        assertEquals(savedProduct.getProductName(), editedProduct.getProductName());
        assertEquals(savedProduct.getProductQuantity(), editedProduct.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("satu");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        service.create(product);

        service.delete("satu");

        List<Product> productIterator = service.findAll();
        assertFalse(productIterator.contains(product));
    }

}
