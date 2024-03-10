package org.bshg.librarysystem.sprocess.content.publisher.delete;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Magazine;

import java.util.List;

public interface DeletePublisherProcess {
    void run(Publisher item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Publisher> items);

    void deleteByAddress(Address address);
}