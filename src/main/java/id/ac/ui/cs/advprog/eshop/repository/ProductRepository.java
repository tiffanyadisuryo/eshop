package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository{
    private List<Product> productData = new ArrayList<>();
    private int idCounter = 1; // id starting point

    public Product create(Product product) {
        productData.add(product);
        product.setProductId(String.valueOf(idCounter));
        idCounter++;
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product edit(Product newProduct) {
        String idProduct = newProduct.getProductId();
        for(Product product : productData){
            if (idProduct.equals(product.getProductId())){
                productData.set(productData.indexOf(product), newProduct);
            }
        }
        return newProduct;
    }
}