package com.kodluyoruz.weekfourjpa.service;

import com.kodluyoruz.weekfourjpa.model.dto.ProductDto;
import com.kodluyoruz.weekfourjpa.model.entity.Product;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekfourjpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductDto createProduct(CreateUpdateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .creationDate(new Date())
                .deleted(false)
                .build();

        Product savedProduct = repository.save(product);
        return convertEntity(savedProduct);
    }

    private ProductDto convertEntity(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public ProductDto getProduct(int id) {
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return convertEntity(product);
    }
}
