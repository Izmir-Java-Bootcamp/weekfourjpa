package com.kodluyoruz.weekfourjpa.model.mapper;

import com.kodluyoruz.weekfourjpa.model.dto.CategoryDto;
import com.kodluyoruz.weekfourjpa.model.dto.ProductDto;
import com.kodluyoruz.weekfourjpa.model.entity.Category;
import com.kodluyoruz.weekfourjpa.model.entity.Product;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateCategoryRequest;
import com.kodluyoruz.weekfourjpa.model.request.CreateUpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtoList(List<Category> category);

    Category createCategory(CreateUpdateCategoryRequest request);
//
//    void updateProduct(@MappingTarget Product product, CreateUpdateProductRequest request);
}
