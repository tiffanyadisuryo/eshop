package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model){
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }
    @GetMapping("/edit/{id}")
    public String editProductPage(Model model, @PathVariable("id") String productId) {
        Product product = new Product();
        product.setProductId(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProductPost(@ModelAttribute Product newProduct, Model model, @PathVariable("id") String productId){
        newProduct.setProductId(productId);
        service.edit(newProduct);
        return "redirect:../list";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") String productId) {
        service.delete(productId);
        return "redirect:../list";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }
}
