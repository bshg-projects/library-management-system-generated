package org.bshg.librarysystem.sprocess.content.publisher.delete;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;
public interface DeletePublisherProcess extends IDeleteProcess<Publisher> {
void deleteByAddress(Address address);
}