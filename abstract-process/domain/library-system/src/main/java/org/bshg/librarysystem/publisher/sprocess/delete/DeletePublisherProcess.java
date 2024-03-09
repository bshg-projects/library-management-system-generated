package org.bshg.librarysystem.publisher.sprocess.delete;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.magazine.Magazine;
public interface DeletePublisherProcess extends IDeleteProcess<Publisher> {
void deleteByAddress(Address address);
}