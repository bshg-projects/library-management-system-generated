package org.bshg.librarysystem.magazine.sprocess.delete;

import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteMagazineProcessImpl implements DeleteMagazineProcess {
    private void process(Magazine item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Magazine item) {
        process(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Magazine item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Magazine item = service.findById(id);
            if (item != null) {
                process(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Magazine> items) {
        items.forEach(this::process);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByGenre(Genre genre) {
        if (genre != null && genre.getId() != null) {
            service.deleteByGenreId(genre.getId());
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByPublisher(Publisher publisher) {
        if (publisher != null && publisher.getId() != null) {
            service.deleteByPublisherId(publisher.getId());
        }
    }

    @Autowired
    private MagazineService service;
    @Autowired
    @Lazy
    private GenreService genreService;
    @Autowired
    @Lazy
    private PublisherService publisherService;
    @Autowired
    @Lazy
    private DeleteGenreProcess deleteGenreProcess;
    @Autowired
    @Lazy
    private DeletePublisherProcess deletePublisherProcess;
}