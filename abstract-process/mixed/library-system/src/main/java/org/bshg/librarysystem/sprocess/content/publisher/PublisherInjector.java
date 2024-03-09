package org.bshg.librarysystem.sprocess.content.publisher;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcessImpl;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcessImpl;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcessImpl;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.update.UpdateAddressProcess;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.update.UpdateBookProcess;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.book.delete.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.library.address.delete.DeleteAddressProcess;
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