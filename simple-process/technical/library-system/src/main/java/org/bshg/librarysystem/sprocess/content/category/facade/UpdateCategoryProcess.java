package org.bshg.librarysystem.sprocess.content.category.facade;

import org.bshg.librarysystem.entity.core.content.Category;
import java.util.List;

public interface UpdateCategoryProcess {
    Category run(Category item);
    List<Category> run(List<Category> items);
}
