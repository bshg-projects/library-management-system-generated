package org.bshg.librarysystem.services.content.category;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.repository.content.CategoryDao;
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