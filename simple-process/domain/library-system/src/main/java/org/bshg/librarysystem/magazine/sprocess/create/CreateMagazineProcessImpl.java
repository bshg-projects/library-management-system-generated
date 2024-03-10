package org.bshg.librarysystem.magazine.sprocess.create;

import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateMagazineProcessImpl implements CreateMagazineProcess {
    @Transactional(rollbackFor = Exception.class)
    public Magazine run(Magazine item) {
// Your Creation Logic For 'Magazine'
        item = service.create(item);
        return item;
    }

    public List<Magazine> run(List<Magazine> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private MagazineService service;
    @Autowired
    private GenreService genreService;
    @Autowired
    @Lazy
    private CreateGenreProcess createGenreProcess;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    @Lazy
    private CreatePublisherProcess createPublisherProcess;
}