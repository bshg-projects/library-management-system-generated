package org.bshg.librarysystem.category.sprocess.create;

import org.bshg.librarysystem.category.Category;

import java.util.List;

public interface CreateCategoryProcess {
    Category run(Category item);

    List<Category> run(List<Category> items);
}