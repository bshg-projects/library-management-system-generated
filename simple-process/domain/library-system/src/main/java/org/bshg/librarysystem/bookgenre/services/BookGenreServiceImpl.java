package org.bshg.librarysystem.bookgenre.services;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.BookGenreDao;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class BookGenreServiceImpl implements BookGenreService {
@Autowired BookGenreDao dao;
@Override
public BookGenre findById(Long id) {
return dao.findById(id).orElse(null);
}
@Override
public List<BookGenre> findAll() {
return dao.findAll();
}
public List<BookGenre> findAllOptimized() {
return dao.findAll();
}
@Transactional(rollbackFor = Exception.class)
@Override
public BookGenre create(BookGenre item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public BookGenre edit(BookGenre item) {
return dao.save(item);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void deleteById(Long id) {
dao.deleteById(id);
}
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(BookGenre item) {
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
public void delete(List<BookGenre> list) {
if (list != null) {
list.forEach(item -> deleteById(item.getId()));
}
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBookId(Long id){
return dao.deleteByBookId(id);
}
@Override
public List<BookGenre> findByBookId(Long id){
return dao.findByBookId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByGenreId(Long id){
return dao.deleteByGenreId(id);
}
@Override
public List<BookGenre> findByGenreId(Long id){
return dao.findByGenreId(id);
}
@Autowired private BookService bookService;
@Autowired private GenreService genreService;
}