package org.bshg.librarysystem.sprocess.content.category.impl;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.sprocess.content.category.facade.DeleteCategoryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteCategoryProcessImpl extends AbstractDeleteProcessImpl<Category, CategoryService> implements DeleteCategoryProcess {
    public DeleteCategoryProcessImpl(CategoryService service) {
        super(service);
    }

    @Override
    protected void process(Category item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }
}