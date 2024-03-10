package org.bshg.librarysystem.sprocess.content.magazine.delete;

import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteMagazineProcessImpl extends AbstractDeleteProcessImpl<Magazine, MagazineService> implements DeleteMagazineProcess {
    public DeleteMagazineProcessImpl(MagazineService service, GenreService genreService, PublisherService publisherService) {
        super(service);
        this.genreService = genreService;
        this.publisherService = publisherService;
    }

    @Override
    protected void process(Magazine item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    public void deleteByGenre(Genre genre) {
        if (genre != null && genre.getId() != null) {
            service.deleteByGenreId(genre.getId());
        }
    }

    public void deleteByPublisher(Publisher publisher) {
        if (publisher != null && publisher.getId() != null) {
            service.deleteByPublisherId(publisher.getId());
        }
    }

    private GenreService genreService;
    private PublisherService publisherService;
    private DeleteGenreProcess deleteGenreProcess;

    public void setDeleteGenreProcess(DeleteGenreProcess value) {
        this.deleteGenreProcess = value;
    }

    private DeletePublisherProcess deletePublisherProcess;

    public void setDeletePublisherProcess(DeletePublisherProcess value) {
        this.deletePublisherProcess = value;
    }
}