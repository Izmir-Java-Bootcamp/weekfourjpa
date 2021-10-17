package com.kodluyoruz.weekfourjpa.service;

import com.kodluyoruz.weekfourjpa.model.dto.ProductDto;
import com.kodluyoruz.weekfourjpa.model.entity.Product;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekfourjpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        Product product = getProductEntity(id);
        return convertEntity(product);
    }

    private Product getProductEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public ProductDto updateProduct(int id, CreateUpdateProductRequest request) {
        Product product = getProductEntity(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setLastModificationDate(new Date());

        Product updatedProduct = repository.save(product);
        return convertEntity(updatedProduct);
    }

    public List<ProductDto> getProducts(String name) {
        if (name != null) {
            return repository.findAllByNameContainsOrDescriptionContains(name, name).stream().map(this::convertEntity).collect(Collectors.toList());
        }

        return repository.findAll().stream().map(this::convertEntity).collect(Collectors.toList());
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
