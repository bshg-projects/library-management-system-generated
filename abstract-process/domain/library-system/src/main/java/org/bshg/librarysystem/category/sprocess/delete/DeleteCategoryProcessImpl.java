package org.bshg.librarysystem.category.sprocess.delete;

import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.services.CategoryService;
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