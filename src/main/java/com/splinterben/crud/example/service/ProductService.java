package com.splinterben.crud.example.service;

import com.splinterben.crud.example.entity.Product;
import com.splinterben.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Save multiple products
     * @param products
     * @return
     */
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    /**
     * Save a single product
     * @param product
     * @return
     */
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    /**
     * Get all products
     * @return
     */
    public List<Product> getProducts() {
        return repository.findAll();
    }

    /**
     * get a single product by Id
     * @param id
     * @return
     */
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Get a single product by Name
     * @param name
     * @return
     */
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    /**
     * Update a single product
     * @param product
     * @return
     */
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
        // return "Product " +existingProduct+ "has been updated !";
    }

    /**
     * Delete a product by Id
     * @param id
     * @return
     */
    public void deleteProductById(int id) {
        repository.deleteById(id);
        // return "Product " +id + "has been deleted !";
    }
}
