package org.bshg.librarysystem.sprocess.content.book.facade;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteBookProcess extends IDeleteProcess<Book> {
    void deleteByEmployee(Employee employee);

    void deleteByPublisher(Publisher publisher);

    void deleteByRack(Rack rack);
}