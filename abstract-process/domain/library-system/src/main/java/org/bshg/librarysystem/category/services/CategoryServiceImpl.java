package org.bshg.librarysystem.category.services;

import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.CategoryDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<Category, CategoryDao> implements CategoryService {
    public CategoryServiceImpl(CategoryDao dao) {
        super(dao);
    }

    @Override
    public List<Category> findAllOptimized() {
        return dao.findAllOptimized();
    }
}