package org.bshg.librarysystem.book.services;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.publisher.Publisher;
import java.util.List;
public interface BookService {
Book findById(Long id);
List<Book> findAllOptimized();
List<Book> findAll();
Book create(Book item);
List<Book> create(List<Book> item);
Book update(Book item);
List<Book> update(List<Book> item);
void deleteById(Long id);
void delete(Book item);
void delete(List<Book> items);
void deleteByIdIn(List<Long> ids);
int deleteByEmployeeId(Long id);
List<Book> findByEmployeeId(Long id);
int deleteByPublisherId(Long id);
List<Book> findByPublisherId(Long id);
int deleteByRackId(Long id);
List<Book> findByRackId(Long id);
}