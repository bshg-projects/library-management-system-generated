package org.bshg.librarysystem.genre;

import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreDao extends Repository<Genre, Long> {
    @Query("SELECT NEW Genre(item.id,item.name) FROM Genre item")
    List<Genre> findAllOptimized();
}