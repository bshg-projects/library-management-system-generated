package org.bshg.librarysystem.sprocess.content.publisher.facade;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeletePublisherProcess extends IDeleteProcess<Publisher> {
    void deleteByAddress(Address address);
}