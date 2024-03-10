package org.bshg.librarysystem.book.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.rack.Rack;

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