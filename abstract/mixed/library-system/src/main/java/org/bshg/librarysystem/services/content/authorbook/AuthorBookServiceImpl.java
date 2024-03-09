
package org.bshg.librarysystem.services.content.authorbook;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.repository.content.AuthorBookDao;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
if (id == null) return 0;
return dao.deleteByAuthorId(id);
}
@Override
public List<AuthorBook> findByAuthorId(Long id){
return dao.findByAuthorId(id);
}
@Override
@Transactional(rollbackFor = Exception.class)
public int deleteByBookId(Long id){
if (id == null) return 0;
return dao.deleteByBookId(id);
}
@Override
public List<AuthorBook> findByBookId(Long id){
return dao.findByBookId(id);
}
@Lazy @Autowired private AuthorService authorService;
@Lazy @Autowired private BookService bookService;
}