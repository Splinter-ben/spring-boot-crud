package com.splinterben.crud.example.controller;

import com.splinterben.crud.example.entity.Product;
import com.splinterben.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Create multiple products
     * @param products
     * @return
     */
    @RequestMapping(
            path = "/addProducts",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    /**
     * Create a product
     * @param product
     * @return
     */
    @RequestMapping(
            path = "/addProduct",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    /**
     * Get all products
     * @return
     */
    @RequestMapping(
            path = "/products",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    /**
     * Get a product by Id
     * @param id
     * @return
     */
    @RequestMapping(
            path = "/productById/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findProductById(@PathVariable("id") int id) {
        return service.getProductById(id);
    }

    /**
     * Get a product by Name
     * @param name
     * @return
     */
    @RequestMapping(
            path = "/productByName/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Product findProductByName(@PathVariable("name") String name) {
        return service.getProductByName(name);
    }

    /**
     * Update a product
     * @param product
     * @return
     */
    @RequestMapping(
            path = "/updateProduct",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
        return "Product " +product+ " has been updated !";
    }

    /**
     * Delete a product by Id
     * @param id
     * @return
     */
    @RequestMapping(
            path = "/deleteProduct/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteProductById(@PathVariable("id") int id) {
        service.deleteProductById(id);
        return "Product N°"+id+ " deleted with success !";
    }
}
