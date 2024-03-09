package org.bshg.librarysystem.publisher.sprocess.update;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdatePublisherProcessImpl extends AbstractUpdateProcessImpl<Publisher, PublisherService> implements UpdatePublisherProcess {
public UpdatePublisherProcessImpl(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
super(service);
this.addressService = addressService;
this.bookService = bookService;
this.magazineService = magazineService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Publisher run(Publisher item) {
// Your Update Logic For 'Publisher'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Publisher item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
bookService::findByPublisherId,
Publisher::getBooks,
Book::setPublisher,
updateBookProcess,
deleteBookProcess
);
ProcessHelper.updateList(
item,
magazineService::findByPublisherId,
Publisher::getMagazines,
Magazine::setPublisher,
updateMagazineProcess,
deleteMagazineProcess
);
}
private AddressService addressService;
private UpdateAddressProcess updateAddressProcess;
private DeleteAddressProcess deleteAddressProcess;
public void setUpdateAddressProcess(UpdateAddressProcess value) {
this.updateAddressProcess = value;
}
public void setDeleteAddressProcess(DeleteAddressProcess value) {
this.deleteAddressProcess = value;
}
private BookService bookService;
private UpdateBookProcess updateBookProcess;
private DeleteBookProcess deleteBookProcess;
public void setUpdateBookProcess(UpdateBookProcess value) {
this.updateBookProcess = value;
}
public void setDeleteBookProcess(DeleteBookProcess value) {
this.deleteBookProcess = value;
}
private MagazineService magazineService;
private UpdateMagazineProcess updateMagazineProcess;
private DeleteMagazineProcess deleteMagazineProcess;
public void setUpdateMagazineProcess(UpdateMagazineProcess value) {
this.updateMagazineProcess = value;
}
public void setDeleteMagazineProcess(DeleteMagazineProcess value) {
this.deleteMagazineProcess = value;
}
}