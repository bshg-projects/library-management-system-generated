package org.bshg.librarysystem.sprocess.content.category.create;
import org.bshg.librarysystem.entity.core.content.Category;
import java.util.List;
public interface CreateCategoryProcess {
Category run(Category item);
List<Category> run(List<Category> items);
}