package org.bshg.librarysystem.webservice.content.category;

import org.bshg.librarysystem.entity.core.content.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
    public void init(boolean initialisation) {
    }

    protected void convertersConfig(boolean value) {
    }

    public final CategoryDto toDto(Category item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Category toItem(CategoryDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Category> toItem(List<CategoryDto> dtos) {
        if (dtos == null) return null;
        List<Category> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<CategoryDto> toDto(List<Category> items) {
        if (items == null) return null;
        List<CategoryDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Category convertToItem(CategoryDto dto) {
        var item = new Category();
        item.setId(dto.getId());
        item.setName(dto.getName());
        return item;
    }

    protected CategoryDto convertToDto(Category item) {
        var dto = new CategoryDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        return dto;
    }
}