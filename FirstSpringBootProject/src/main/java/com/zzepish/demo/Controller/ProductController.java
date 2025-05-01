package com.zzepish.demo.Controller;

import com.zzepish.demo.Entity.Product;
import com.zzepish.demo.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> get() {
        return this.productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = this.productService.findById(id);

        if(null == product) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> post(@ModelAttribute Product product, @RequestPart MultipartFile image) {
        try {
            Product savedProduct = this.productService.saveOrUpdate(product, image);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> productImage(@PathVariable Long id)
    {
        Product product = this.productService.findById(id);

        if (null == product || null == product.getImageBlob()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", product.getImageType());

        return new ResponseEntity<>(product.getImageBlob(), headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id,
            @ModelAttribute Product product,
            @RequestPart MultipartFile image
    ) {
        try {
            product.setId(id);
            return new ResponseEntity<>(this.productService.saveOrUpdate(product, image), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        this.productService.delete(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String search)
    {
        return this.productService.search(search);
    }
}
