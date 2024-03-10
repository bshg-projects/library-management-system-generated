package org.bshg.librarysystem.publisher;

import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherDao extends Repository<Publisher, Long> {
    int deleteByAddressId(Long id);

    Publisher findByAddressId(Long id);

    @Query("SELECT NEW Publisher(item.id,item.name) FROM Publisher item")
    List<Publisher> findAllOptimized();
}