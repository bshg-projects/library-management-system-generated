package org.bshg.librarysystem.category.sprocess.update;

import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.services.CategoryService;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateCategoryProcessImpl extends AbstractUpdateProcessImpl<Category, CategoryService> implements UpdateCategoryProcess {
    public UpdateCategoryProcessImpl(CategoryService service) {
        super(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Category run(Category item) {
// Your Update Logic For 'Category'
        item = service.edit(item);
        return item;
    }
}