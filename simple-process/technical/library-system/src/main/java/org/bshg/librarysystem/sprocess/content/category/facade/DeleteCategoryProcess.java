package org.bshg.librarysystem.sprocess.content.category.facade;

import org.bshg.librarysystem.entity.core.content.Category;

import java.util.List;

public interface DeleteCategoryProcess {
    void run(Category item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Category> items);
}