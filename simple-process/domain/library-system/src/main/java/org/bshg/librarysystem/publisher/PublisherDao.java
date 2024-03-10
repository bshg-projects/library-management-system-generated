package org.bshg.librarysystem.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherDao extends JpaRepository<Publisher, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByAddressId(Long id);

    Publisher findByAddressId(Long id);

    @Query("SELECT NEW Publisher(item.id,item.name) FROM Publisher item")
    List<Publisher> findAllOptimized();
}