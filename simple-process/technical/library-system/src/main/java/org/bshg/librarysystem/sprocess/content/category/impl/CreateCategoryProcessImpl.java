package org.bshg.librarysystem.sprocess.content.category.impl;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.sprocess.content.category.facade.CreateCategoryProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateCategoryProcessImpl implements CreateCategoryProcess {
    @Transactional(rollbackFor = Exception.class)
    public Category run(Category item) {
// Your Creation Logic For 'Category'
        item = service.create(item);
        return item;
    }

    public List<Category> run(List<Category> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private CategoryService service;
}