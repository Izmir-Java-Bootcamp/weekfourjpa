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

import static com.kodluyoruz.weekfourjpa.model.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductDto createProduct(CreateUpdateProductRequest request) {
        Product product = PRODUCT_MAPPER.createProduct(request);

        Product savedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(savedProduct);
    }


    public ProductDto getProduct(int id) {
        Product product = getProductEntity(id);
        return PRODUCT_MAPPER.toProductDto(product);
    }

    private Product getProductEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public ProductDto updateProduct(int id, CreateUpdateProductRequest request) {
        Product product = getProductEntity(id);
        PRODUCT_MAPPER.updateProduct(product, request);

        Product updatedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(updatedProduct);
    }

    public List<ProductDto> getProducts(String name) {
        if (name != null) {
            return PRODUCT_MAPPER.toProductDtoList(repository.findAllByNameContainsOrDescriptionContains(name, name));
        }

        return PRODUCT_MAPPER.toProductDtoList(repository.findAll());
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
