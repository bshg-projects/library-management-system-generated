package org.bshg.librarysystem.authorbook.services;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface AuthorBookService extends IService<AuthorBook> {
int deleteByAuthorId(Long id);
List<AuthorBook> findByAuthorId(Long id);
int deleteByBookId(Long id);
List<AuthorBook> findByBookId(Long id);
}