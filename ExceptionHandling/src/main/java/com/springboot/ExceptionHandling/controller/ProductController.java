package com.springboot.ExceptionHandling.controller;
import com.springboot.ExceptionHandling.model.Product;
import com.springboot.ExceptionHandling.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
public class ProductController {
    @Autowired
    ProductRepository proRepository;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(proRepository.findAll());
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = proRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Not found product with id " + id));
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proRepository.save(product));
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productRequest) {
        Product product = proRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Not found product with id " + id));
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        return ResponseEntity.status(HttpStatus.OK).body(proRepository.save(product));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = proRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Not found product with id " + id));
        proRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product" + id + " deleted succesfully");
    }

}
