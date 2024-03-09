package org.bshg.librarysystem.category.sprocess.delete;
import org.bshg.librarysystem.category.Category;
import java.util.List;
public interface DeleteCategoryProcess {
void run(Category item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Category> items);
}