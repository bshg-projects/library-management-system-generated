package org.bshg.librarysystem.authorbook.services;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.AuthorBookDao;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.author.services.AuthorService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class AuthorBookServiceImpl extends ServiceImpl<AuthorBook, AuthorBookDao> implements AuthorBookService {
public AuthorBookServiceImpl(AuthorBookDao dao) {
super(dao);
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