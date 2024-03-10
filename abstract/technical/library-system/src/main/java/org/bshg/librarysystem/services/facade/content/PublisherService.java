package org.bshg.librarysystem.services.facade.content;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.utils.service.IService;

public interface PublisherService extends IService<Publisher> {
    int deleteByAddressId(Long id);

    Publisher findByAddressId(Long id);
}