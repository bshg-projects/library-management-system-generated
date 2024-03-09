package org.bshg.librarysystem.category;
import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CategoryDao extends Repository<Category, Long> {
@Query("SELECT NEW Category(item.id,item.name) FROM Category item")
List<Category> findAllOptimized();
}