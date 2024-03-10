package org.bshg.librarysystem.sprocess.content.publisher.create;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.sprocess.content.book.create.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.library.address.create.CreateAddressProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreatePublisherProcessImpl extends AbstractCreateProcessImpl<Publisher, PublisherService> implements CreatePublisherProcess {
    public CreatePublisherProcessImpl(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
        super(service);
        this.addressService = addressService;
        this.bookService = bookService;
        this.magazineService = magazineService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Publisher run(Publisher item) {
// Your Insert Logic For 'Publisher'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    @Override
    public void createAssociatedList(Publisher item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Publisher::getBooks, Book::setPublisher, createBookProcess);
        ProcessHelper.createList(item, Publisher::getMagazines, Magazine::setPublisher, createMagazineProcess);
    }

    private AddressService addressService;
    private CreateAddressProcess createAddressProcess;

    public void setCreateAddressProcess(CreateAddressProcess value) {
        this.createAddressProcess = value;
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private MagazineService magazineService;
    private CreateMagazineProcess createMagazineProcess;

    public void setCreateMagazineProcess(CreateMagazineProcess value) {
        this.createMagazineProcess = value;
    }
}