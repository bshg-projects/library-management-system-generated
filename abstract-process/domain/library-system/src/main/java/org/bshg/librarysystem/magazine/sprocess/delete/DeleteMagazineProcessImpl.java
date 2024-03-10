package org.bshg.librarysystem.magazine.sprocess.delete;

import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
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