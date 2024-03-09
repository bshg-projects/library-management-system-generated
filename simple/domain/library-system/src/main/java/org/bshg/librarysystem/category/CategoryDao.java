package org.bshg.librarysystem.category;
import org.bshg.librarysystem.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CategoryDao extends JpaRepository<Category, Long> {
int deleteByIdIn(List<Long> ids);
@Query("SELECT NEW Category(item.id,item.name) FROM Category item")
List<Category> findAllOptimized();
}