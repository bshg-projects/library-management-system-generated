package org.bshg.librarysystem.publisher.sprocess.create;

import org.bshg.librarysystem.address.services.AddressService;
import org.bshg.librarysystem.address.sprocess.create.CreateAddressProcess;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreatePublisherProcessImpl implements CreatePublisherProcess {
    @Transactional(rollbackFor = Exception.class)
    public Publisher run(Publisher item) {
// Your Creation Logic For 'Publisher'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Publisher> run(List<Publisher> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Publisher item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Publisher::getBooks, Book::setPublisher, createBookProcess::run);
        ProcessHelper.createList(item, Publisher::getMagazines, Magazine::setPublisher, createMagazineProcess::run);
    }

    @Autowired
    private PublisherService service;
    @Autowired
    private AddressService addressService;
    @Autowired
    @Lazy
    private CreateAddressProcess createAddressProcess;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private MagazineService magazineService;
    @Autowired
    @Lazy
    private CreateMagazineProcess createMagazineProcess;
}