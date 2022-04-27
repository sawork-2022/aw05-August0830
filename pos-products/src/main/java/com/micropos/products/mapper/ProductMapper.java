package com.micropos.products.mapper;

import com.micropos.dto.ProductDto;
import com.micropos.products.model.Product;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@Mapper
@Bean 
public interface ProductMapper {

    Collection<ProductDto> toProductsDto(Collection<Product> products);

    Collection<Product> toProducts(Collection<ProductDto> products);

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product pet);
}
