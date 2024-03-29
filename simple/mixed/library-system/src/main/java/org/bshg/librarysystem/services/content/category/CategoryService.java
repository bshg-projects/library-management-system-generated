package org.bshg.librarysystem.services.content.category;

import org.bshg.librarysystem.entity.core.content.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    List<Category> findAllOptimized();

    List<Category> findAll();

    Category create(Category item);

    List<Category> create(List<Category> item);

    Category update(Category item);

    List<Category> update(List<Category> item);

    void deleteById(Long id);

    void delete(Category item);

    void delete(List<Category> items);

    void deleteByIdIn(List<Long> ids);
}