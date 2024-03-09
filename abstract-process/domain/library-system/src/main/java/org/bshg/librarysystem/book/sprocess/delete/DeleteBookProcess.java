package org.bshg.librarysystem.book.sprocess.delete;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.publisher.Publisher;
public interface DeleteBookProcess extends IDeleteProcess<Book> {
void deleteByEmployee(Employee employee);
void deleteByPublisher(Publisher publisher);
void deleteByRack(Rack rack);
}