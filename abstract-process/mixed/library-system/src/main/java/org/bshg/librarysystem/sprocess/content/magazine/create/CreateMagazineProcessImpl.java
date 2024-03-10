package org.bshg.librarysystem.sprocess.content.magazine.create;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateMagazineProcessImpl extends AbstractCreateProcessImpl<Magazine, MagazineService> implements CreateMagazineProcess {
    public CreateMagazineProcessImpl(MagazineService service, GenreService genreService, PublisherService publisherService) {
        super(service);
        this.genreService = genreService;
        this.publisherService = publisherService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Magazine run(Magazine item) {
// Your Insert Logic For 'Magazine'
        item = service.create(item);
        return item;
    }

    private GenreService genreService;
    private CreateGenreProcess createGenreProcess;

    public void setCreateGenreProcess(CreateGenreProcess value) {
        this.createGenreProcess = value;
    }

    private PublisherService publisherService;
    private CreatePublisherProcess createPublisherProcess;

    public void setCreatePublisherProcess(CreatePublisherProcess value) {
        this.createPublisherProcess = value;
    }
}