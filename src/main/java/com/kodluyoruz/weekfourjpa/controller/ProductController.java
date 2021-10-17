package com.kodluyoruz.weekfourjpa.controller;

import com.kodluyoruz.weekfourjpa.model.dto.ProductDto;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.weekfourjpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody CreateUpdateProductRequest request){
        return service.createProduct(request);
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable int id){
        return service.getProduct(id);
    }



}
