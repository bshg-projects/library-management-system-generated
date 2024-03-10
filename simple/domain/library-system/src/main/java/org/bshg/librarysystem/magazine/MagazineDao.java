package org.bshg.librarysystem.magazine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MagazineDao extends JpaRepository<Magazine, Long> {
    int deleteByIdIn(List<Long> ids);

    int deleteByGenreId(Long id);

    List<Magazine> findByGenreId(Long id);

    int deleteByPublisherId(Long id);

    List<Magazine> findByPublisherId(Long id);

    @Query("SELECT NEW Magazine(item.id,item.title) FROM Magazine item")
    List<Magazine> findAllOptimized();
}