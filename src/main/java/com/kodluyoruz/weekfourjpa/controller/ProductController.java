package com.kodluyoruz.weekfourjpa.controller;

import com.kodluyoruz.weekfourjpa.model.dto.ProductDto;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekfourjpa.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ProductDto createProduct(@RequestBody CreateUpdateProductRequest request){
        return service.createProduct(request);
    }
}
