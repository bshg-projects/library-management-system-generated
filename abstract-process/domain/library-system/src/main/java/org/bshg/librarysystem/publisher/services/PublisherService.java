package org.bshg.librarysystem.publisher.services;

import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.utils.service.IService;

public interface PublisherService extends IService<Publisher> {
    int deleteByAddressId(Long id);

    Publisher findByAddressId(Long id);
}