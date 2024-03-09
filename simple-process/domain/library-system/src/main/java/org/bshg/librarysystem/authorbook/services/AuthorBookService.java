package org.bshg.librarysystem.authorbook.services;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.author.Author;
import java.util.List;
public interface AuthorBookService {
AuthorBook findById(Long id);
List<AuthorBook> findAllOptimized();
List<AuthorBook> findAll();
AuthorBook create(AuthorBook item);
AuthorBook edit(AuthorBook item);
void deleteById(Long id);
void delete(AuthorBook item);
void delete(List<AuthorBook> items);
void deleteByIdIn(List<Long> ids);
int deleteByAuthorId(Long id);
List<AuthorBook> findByAuthorId(Long id);
int deleteByBookId(Long id);
List<AuthorBook> findByBookId(Long id);
}