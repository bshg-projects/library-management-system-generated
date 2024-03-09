package org.bshg.librarysystem.book.sprocess.delete;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.publisher.Publisher;
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