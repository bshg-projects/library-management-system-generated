package org.bshg.librarysystem.category.sprocess.update;

import org.bshg.librarysystem.category.Category;

import java.util.List;

public interface UpdateCategoryProcess {
    Category run(Category item);

    List<Category> run(List<Category> items);
}
