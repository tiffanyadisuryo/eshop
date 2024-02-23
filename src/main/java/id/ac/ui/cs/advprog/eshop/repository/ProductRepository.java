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

    public Product create(Product product) throws IllegalArgumentException{
        if (product.getProductId() == null){
            product.setProductId(String.valueOf(idCounter));
        }
        idCounter++;
        if (product.getProductQuantity() < 0){
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }

    public Product findById(String idProduct) throws IllegalArgumentException{
        for(Product product : productData){
            if (idProduct.equals(product.getProductId())){
                return product;
            }
        }
        throw new IllegalArgumentException();
    }

    public Product edit(Product newProduct){
        String idProduct = newProduct.getProductId();
        productData.set(productData.indexOf(findById(idProduct)), newProduct);
        return newProduct;
    }

    public String delete(String idProduct){
        productData.remove(findById(idProduct));
        return idProduct;
    }
}