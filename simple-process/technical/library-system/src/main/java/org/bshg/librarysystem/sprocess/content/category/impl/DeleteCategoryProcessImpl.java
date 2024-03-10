package org.bshg.librarysystem.sprocess.content.category.impl;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.sprocess.content.category.facade.DeleteCategoryProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteCategoryProcessImpl implements DeleteCategoryProcess {
    private void process(Category item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Category item) {
        process(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Category item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Category item = service.findById(id);
            if (item != null) {
                process(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Category> items) {
        items.forEach(this::process);
        service.delete(items);
    }

    @Autowired
    private CategoryService service;
}