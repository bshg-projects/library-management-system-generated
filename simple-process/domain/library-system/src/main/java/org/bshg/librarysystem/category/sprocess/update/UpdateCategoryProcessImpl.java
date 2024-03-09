package org.bshg.librarysystem.category.sprocess.update;
import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.services.CategoryService;
import org.bshg.librarysystem.category.sprocess.update.UpdateCategoryProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
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
@Autowired private CategoryService service;
}