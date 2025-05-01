package com.zzepish.demo;

import com.zzepish.demo.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll()
    {
        return this.productRepository.findAll();
    }

    public Product findById(Long id)
    {
        return this.productRepository.findById(id).orElse(null);
    }

    public Product saveOrUpdate(Product product, MultipartFile image) throws IOException {
        if (null != image) {
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            product.setImageBlob(image.getBytes());
        }

        this.productRepository.save(product);
        return product;
    }

    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    public List<Product> search(String keyword) {
        return this.productRepository.search(keyword);
    }
}
