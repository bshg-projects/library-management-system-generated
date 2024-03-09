package org.bshg.librarysystem.publisher.sprocess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcessImpl;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcessImpl;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcessImpl;
import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.address.sprocess.update.UpdateAddressProcess;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.book.sprocess.update.UpdateBookProcess;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.book.sprocess.delete.DeleteBookProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.address.sprocess.delete.DeleteAddressProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Publisher Processes (Create, Update, Delete).
*/
@Configuration
public class PublisherInjector {
@Bean
public CreatePublisherProcess createPublisherProcess (PublisherService service,AddressService addressService,BookService bookService,MagazineService magazineService) {
var bean = new CreatePublisherProcessImpl(service, addressService, bookService, magazineService);
bean.setCreateAddressProcess(this.createAddressProcess);
bean.setCreateBookProcess(this.createBookProcess);
bean.setCreateMagazineProcess(this.createMagazineProcess);
return bean;
}
@Bean
public UpdatePublisherProcess updatePublisherProcess (PublisherService service,AddressService addressService,BookService bookService,MagazineService magazineService) {
var bean = new UpdatePublisherProcessImpl(service,addressService,bookService,magazineService);
bean.setUpdateAddressProcess(this.updateAddressProcess);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
bean.setUpdateBookProcess(this.updateBookProcess);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setUpdateMagazineProcess(this.updateMagazineProcess);
bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
return bean;
}
@Bean
public DeletePublisherProcess deletePublisherProcess(PublisherService service,AddressService addressService,BookService bookService,MagazineService magazineService) {
var bean = new DeletePublisherProcessImpl(service,addressService,bookService,magazineService);
bean.setDeleteBookProcess(this.deleteBookProcess);
bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
bean.setDeleteAddressProcess(this.deleteAddressProcess);
return bean;
}
@Autowired @Lazy private CreateAddressProcess createAddressProcess;
@Autowired @Lazy private UpdateAddressProcess updateAddressProcess;
@Autowired @Lazy private CreateBookProcess createBookProcess;
@Autowired @Lazy private UpdateBookProcess updateBookProcess;
@Autowired @Lazy private CreateMagazineProcess createMagazineProcess;
@Autowired @Lazy private UpdateMagazineProcess updateMagazineProcess;
@Autowired @Lazy private DeleteBookProcess deleteBookProcess;
@Autowired @Lazy private DeleteMagazineProcess deleteMagazineProcess;
@Autowired @Lazy private DeleteAddressProcess deleteAddressProcess;
}