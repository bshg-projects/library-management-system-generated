package org.bshg.librarysystem.services.content.magazine;

import org.bshg.librarysystem.entity.core.content.Magazine;

import java.util.List;

public interface MagazineService {
    Magazine findById(Long id);

    List<Magazine> findAllOptimized();

    List<Magazine> findAll();

    Magazine create(Magazine item);

    List<Magazine> create(List<Magazine> item);

    Magazine update(Magazine item);

    List<Magazine> update(List<Magazine> item);

    void deleteById(Long id);

    void delete(Magazine item);

    void delete(List<Magazine> items);

    void deleteByIdIn(List<Long> ids);

    int deleteByGenreId(Long id);

    List<Magazine> findByGenreId(Long id);

    int deleteByPublisherId(Long id);

    List<Magazine> findByPublisherId(Long id);
}