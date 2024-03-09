
package org.bshg.librarysystem.services.impl.content;
import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.repository.content.CategoryDao;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
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