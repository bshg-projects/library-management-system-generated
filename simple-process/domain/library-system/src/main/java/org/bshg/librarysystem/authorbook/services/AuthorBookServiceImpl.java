package org.bshg.librarysystem.authorbook.services;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.AuthorBookDao;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AuthorBookServiceImpl implements AuthorBookService {
@Autowired AuthorBookDao dao;
@Override
public AuthorBook findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<AuthorBook> findAll() {
return dao.findAll();
}
public List<AuthorBook> findAllOptimized() {
return dao.findAll();
}
@Transactional(rollbackFor = Exception.class)
@Override
public AuthorBook create(AuthorBook item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public AuthorBook edit(AuthorBook item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(AuthorBook item) {
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
public void delete(List<AuthorBook> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByAuthorId(Long id){
return dao.deleteByAuthorId(id);
}
@Override
public List<AuthorBook> findByAuthorId(Long id){
return dao.findByAuthorId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBookId(Long id){
return dao.deleteByBookId(id);
}
@Override
public List<AuthorBook> findByBookId(Long id){
return dao.findByBookId(id);
}
@Autowired private AuthorService authorService;
@Autowired private BookService bookService;
}