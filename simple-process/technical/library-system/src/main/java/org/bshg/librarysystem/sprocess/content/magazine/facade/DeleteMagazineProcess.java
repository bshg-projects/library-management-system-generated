package org.bshg.librarysystem.sprocess.content.magazine.facade;

import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.entity.core.content.Publisher;

import java.util.List;

public interface DeleteMagazineProcess {
    void run(Magazine item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Magazine> items);

    void deleteByGenre(Genre genre);

    void deleteByPublisher(Publisher publisher);
}