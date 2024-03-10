package org.bshg.librarysystem.webservice.content.category;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.webservice.content.category.CategoryDto;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractConverter<Category, CategoryDto> {
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