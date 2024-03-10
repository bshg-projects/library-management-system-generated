package org.bshg.librarysystem.repository.content;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MagazineDao extends Repository<Magazine, Long> {
    int deleteByGenreId(Long id);

    List<Magazine> findByGenreId(Long id);

    int deleteByPublisherId(Long id);

    List<Magazine> findByPublisherId(Long id);

    @Query("SELECT NEW Magazine(item.id,item.title) FROM Magazine item")
    List<Magazine> findAllOptimized();
}