package org.bshg.librarysystem.category.webservice;

import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDto> {
    @Override
    protected void config() {
        config(Category.class, CategoryDto.class);
    }

    @Override
    protected Category convertToItem(CategoryDto dto) {
        var item = new Category();
        item.setId(dto.getId());
        item.setName(dto.getName());
        return item;
    }

    @Override
    protected CategoryDto convertToDto(Category item) {
        var dto = new CategoryDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        return dto;
    }
}