package org.bshg.librarysystem.magazine.sprocess.update;

import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
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