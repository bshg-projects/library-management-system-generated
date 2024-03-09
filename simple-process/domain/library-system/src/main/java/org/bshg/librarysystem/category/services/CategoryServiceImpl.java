package org.bshg.librarysystem.category.services;
import org.bshg.librarysystem.category.Category;
import org.bshg.librarysystem.category.CategoryDao;
import org.bshg.librarysystem.category.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired CategoryDao dao;
@Override
public Category findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<Category> findAll() {
return dao.findAll();
}
public List<Category> findAllOptimized() {
return dao.findAllOptimized();
}
@Transactional(rollbackFor = Exception.class)
@Override
public Category create(Category item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public Category edit(Category item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Category item) {
if (item == null)
return;
dao.deleteById(item.getId());
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(List<Category> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
}