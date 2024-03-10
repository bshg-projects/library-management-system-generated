package org.bshg.librarysystem.sprocess.content.category.impl;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.sprocess.content.category.facade.CreateCategoryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateCategoryProcessImpl extends AbstractCreateProcessImpl<Category, CategoryService> implements CreateCategoryProcess {
    public CreateCategoryProcessImpl(CategoryService service) {
        super(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Category run(Category item) {
// Your Insert Logic For 'Category'
        item = service.create(item);
        return item;
    }
}