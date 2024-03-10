package org.bshg.librarysystem.sprocess.content.magazine.impl;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateMagazineProcessImpl extends AbstractUpdateProcessImpl<Magazine, MagazineService> implements UpdateMagazineProcess {
    public UpdateMagazineProcessImpl(MagazineService service, GenreService genreService, PublisherService publisherService) {
        super(service);
        this.genreService = genreService;
        this.publisherService = publisherService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Magazine run(Magazine item) {
// Your Update Logic For 'Magazine'
        item = service.edit(item);
        return item;
    }

    private GenreService genreService;
    private UpdateGenreProcess updateGenreProcess;
    private DeleteGenreProcess deleteGenreProcess;

    public void setUpdateGenreProcess(UpdateGenreProcess value) {
        this.updateGenreProcess = value;
    }

    public void setDeleteGenreProcess(DeleteGenreProcess value) {
        this.deleteGenreProcess = value;
    }

    private PublisherService publisherService;
    private UpdatePublisherProcess updatePublisherProcess;
    private DeletePublisherProcess deletePublisherProcess;

    public void setUpdatePublisherProcess(UpdatePublisherProcess value) {
        this.updatePublisherProcess = value;
    }

    public void setDeletePublisherProcess(DeletePublisherProcess value) {
        this.deletePublisherProcess = value;
    }
}