package org.bshg.librarysystem.sprocess.content.publisher.impl;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.services.facade.library.AddressService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.DeleteAddressProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class DeletePublisherProcessImpl extends AbstractDeleteProcessImpl<Publisher, PublisherService> implements DeletePublisherProcess {
    public DeletePublisherProcessImpl(PublisherService service, AddressService addressService, BookService bookService, MagazineService magazineService) {
        super(service);
        this.addressService = addressService;
        this.bookService = bookService;
        this.magazineService = magazineService;
    }

    @Override
    protected void process(Publisher item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByAddress(Address address) {
        if (address != null && address.getId() != null) {
            Publisher found = this.service.findByAddressId(address.getId());
            if (found == null) return;
            this.deleteAssociated(found);
            service.deleteByAddressId(address.getId());
        }
    }

    @Override
    public void deleteAssociatedList(Publisher item) {
        deleteBookProcess.deleteByPublisher(item);
        deleteMagazineProcess.deleteByPublisher(item);
    }

    private AddressService addressService;
    private BookService bookService;
    private MagazineService magazineService;
    private DeleteBookProcess deleteBookProcess;

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
    }

    private DeleteMagazineProcess deleteMagazineProcess;

    public void setDeleteMagazineProcess(DeleteMagazineProcess value) {
        this.deleteMagazineProcess = value;
    }

    private DeleteAddressProcess deleteAddressProcess;

    public void setDeleteAddressProcess(DeleteAddressProcess value) {
        this.deleteAddressProcess = value;
    }
}