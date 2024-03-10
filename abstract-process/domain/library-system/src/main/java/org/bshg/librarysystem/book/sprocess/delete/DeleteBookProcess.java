package org.bshg.librarysystem.book.sprocess.delete;

import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteBookProcess extends IDeleteProcess<Book> {
    void deleteByEmployee(Employee employee);

    void deleteByPublisher(Publisher publisher);

    void deleteByRack(Rack rack);
}