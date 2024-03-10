package org.bshg.librarysystem.sprocess.content.category.update;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.content.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateCategoryProcessImpl implements UpdateCategoryProcess {
    @Transactional(rollbackFor = Exception.class)
    public Category run(Category item) { // Your Logic To Update 'Category'
        item = service.edit(item);
        return item;
    }

    public List<Category> run(List<Category> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private CategoryService service;
}