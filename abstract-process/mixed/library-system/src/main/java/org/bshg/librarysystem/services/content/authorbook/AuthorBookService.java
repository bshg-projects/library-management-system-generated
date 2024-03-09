package org.bshg.librarysystem.services.content.authorbook;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface AuthorBookService extends IService<AuthorBook> {
int deleteByAuthorId(Long id);
List<AuthorBook> findByAuthorId(Long id);
int deleteByBookId(Long id);
List<AuthorBook> findByBookId(Long id);
}