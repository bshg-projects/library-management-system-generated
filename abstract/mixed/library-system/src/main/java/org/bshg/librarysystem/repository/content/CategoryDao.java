package org.bshg.librarysystem.repository.content;

import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends Repository<Category, Long> {
    @Query("SELECT NEW Category(item.id,item.name) FROM Category item")
    List<Category> findAllOptimized();
}