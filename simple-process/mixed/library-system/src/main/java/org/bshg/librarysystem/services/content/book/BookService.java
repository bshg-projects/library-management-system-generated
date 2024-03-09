package org.bshg.librarysystem.services.content.book;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Publisher;
import java.util.List;
public interface BookService {
Book findById(Long id);
List<Book> findAllOptimized();
List<Book> findAll();
Book create(Book item);
Book edit(Book item);
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