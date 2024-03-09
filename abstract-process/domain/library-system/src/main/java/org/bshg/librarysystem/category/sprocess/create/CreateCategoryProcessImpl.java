package org.bshg.librarysystem.category.sprocess.create;
import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.services.CategoryService;
import org.bshg.librarysystem.category.sprocess.create.CreateCategoryProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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