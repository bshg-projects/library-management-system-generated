package org.bshg.librarysystem.sprocess.content.publisher;

import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.impl.CreatePublisherProcessImpl;
import org.bshg.librarysystem.sprocess.content.publisher.impl.DeletePublisherProcessImpl;
import org.bshg.librarysystem.sprocess.content.publisher.impl.UpdatePublisherProcessImpl;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.UpdateAddressProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Publisher Processes (Create, Update, Delete).
 */
@Configuration
public class PublisherInjector {
    @Bean
    public CreatePublisherProcess createPublisherProcess(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
        var bean = new CreatePublisherProcessImpl(service, addressService, bookService, magazineService);
        bean.setCreateAddressProcess(this.createAddressProcess);
        bean.setCreateBookProcess(this.createBookProcess);
        bean.setCreateMagazineProcess(this.createMagazineProcess);
        return bean;
    }

    @Bean
    public UpdatePublisherProcess updatePublisherProcess(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
        var bean = new UpdatePublisherProcessImpl(service, addressService, bookService, magazineService);
        bean.setUpdateAddressProcess(this.updateAddressProcess);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        bean.setUpdateBookProcess(this.updateBookProcess);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setUpdateMagazineProcess(this.updateMagazineProcess);
        bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
        return bean;
    }

    @Bean
    public DeletePublisherProcess deletePublisherProcess(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
        var bean = new DeletePublisherProcessImpl(service, addressService, bookService, magazineService);
        bean.setDeleteBookProcess(this.deleteBookProcess);
        bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
        bean.setDeleteAddressProcess(this.deleteAddressProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    @Lazy
    private UpdateAddressProcess updateAddressProcess;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    @Lazy
    private UpdateBookProcess updateBookProcess;
    @Autowired
    @Lazy
    private CreateMagazineProcess createMagazineProcess;
    @Autowired
    @Lazy
    private UpdateMagazineProcess updateMagazineProcess;
    @Autowired
    @Lazy
    private DeleteBookProcess deleteBookProcess;
    @Autowired
    @Lazy
    private DeleteMagazineProcess deleteMagazineProcess;
    @Autowired
    @Lazy
    private DeleteAddressProcess deleteAddressProcess;
}