package org.bshg.librarysystem.publisher.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.publisher.Publisher;

import java.util.List;

public interface DeletePublisherProcess {
    void run(Publisher item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Publisher> items);

    void deleteByAddress(Address address);
}