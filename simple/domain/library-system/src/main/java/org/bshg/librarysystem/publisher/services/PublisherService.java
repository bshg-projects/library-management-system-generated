package org.bshg.librarysystem.publisher.services;

import org.bshg.librarysystem.publisher.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher findById(Long id);

    List<Publisher> findAllOptimized();

    List<Publisher> findAll();

    Publisher create(Publisher item);

    List<Publisher> create(List<Publisher> item);

    Publisher update(Publisher item);

    List<Publisher> update(List<Publisher> item);

    void deleteById(Long id);

    void delete(Publisher item);

    void delete(List<Publisher> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    Publisher findByAddressId(Long id);
}