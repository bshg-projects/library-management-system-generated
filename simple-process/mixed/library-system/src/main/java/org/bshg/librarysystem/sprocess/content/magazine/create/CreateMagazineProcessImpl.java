package org.bshg.librarysystem.sprocess.content.magazine.create;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
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