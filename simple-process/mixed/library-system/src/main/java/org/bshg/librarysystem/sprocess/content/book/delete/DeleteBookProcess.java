package org.bshg.librarysystem.sprocess.content.book.delete;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Publisher;
import java.util.List;
public interface DeleteBookProcess {
void run(Book item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Book> items);
void deleteByEmployee(Employee employee);
void deleteByPublisher(Publisher publisher);
void deleteByRack(Rack rack);
}