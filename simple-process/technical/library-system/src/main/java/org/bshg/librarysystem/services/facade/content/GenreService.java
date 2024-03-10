package org.bshg.librarysystem.services.facade.content;

import org.bshg.librarysystem.entity.core.content.Genre;

import java.util.List;

public interface GenreService {
    Genre findById(Long id);

    List<Genre> findAllOptimized();

    List<Genre> findAll();

    Genre create(Genre item);

    Genre edit(Genre item);

    void deleteById(Long id);

    void delete(Genre item);

    void delete(List<Genre> items);

    void deleteByIdIn(List<Long> ids);
}