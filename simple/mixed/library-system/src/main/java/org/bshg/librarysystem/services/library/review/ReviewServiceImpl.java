package org.bshg.librarysystem.services.library.review;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.repository.library.ReviewDao;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
@Service
public class ReviewServiceImpl implements ReviewService {
//--------------- FIND -------------------------------------
public Review findById(Long id) {
return dao.findById(id).orElse(null);
}
public List<Review> findAll() {
return dao.findAll();
}
public List<Review> findAllOptimized() {
return dao.findAllOptimized();
}
//--------------- CREATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Review create(Review item) {
if (item == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Review> create(List<Review> items) {
List<Review> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(create(it)));
return result;
}
//--------------- UPDATE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public Review update(Review item) {
if (item == null || item.getId() == null) return null;
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
public List<Review> update(List<Review> items) {
List<Review> result = new ArrayList<>();
if (items == null || items.isEmpty()) return result;
items.forEach(it -> result.add(update(it)));
return result;
}
//--------------- DELETE -----------------------------------
@Transactional(rollbackFor = Exception.class)
public void deleteById(Long id) {
Review item = findById(id);
if (item != null) delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(Review item) {
dao.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void delete(List<Review> items) {
if (items == null || items.isEmpty()) return;
items.forEach(this::delete);
}
@Transactional(rollbackFor = Exception.class)
public void deleteByIdIn(List<Long> ids) {
dao.deleteByIdIn(ids);
}
//--------------- FIND AND DELETE BYs ----------------------
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBookId(Long id){
return dao.deleteByBookId(id);
}
@Override
public Review findByBookId(Long id){
return dao.findByBookId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByClientId(Long id){
if (id == null) return 0;
return dao.deleteByClientId(id);
}
@Override
public List<Review> findByClientId(Long id){
return dao.findByClientId(id);
}
//----------------------------------------------------------
//----------------------------------------------------------
@Autowired private ReviewDao dao;
@Lazy @Autowired private BookService bookService;
@Lazy @Autowired private ClientService clientService;
}