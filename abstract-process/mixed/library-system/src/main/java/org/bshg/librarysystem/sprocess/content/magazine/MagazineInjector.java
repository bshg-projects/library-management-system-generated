package org.bshg.librarysystem.sprocess.content.magazine;

import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.update.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcessImpl;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcessImpl;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcessImpl;
import org.bshg.librarysystem.sprocess.content.publisher.create.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Magazine Processes (Create, Update, Delete).
 */
@Configuration
public class MagazineInjector {
    @Bean
    public CreateMagazineProcess createMagazineProcess(MagazineService service, GenreService genreService, PublisherService publisherService) {
        var bean = new CreateMagazineProcessImpl(service, genreService, publisherService);
        bean.setCreateGenreProcess(this.createGenreProcess);
        bean.setCreatePublisherProcess(this.createPublisherProcess);
        return bean;
    }

    @Bean
    public UpdateMagazineProcess updateMagazineProcess(MagazineService service, GenreService genreService, PublisherService publisherService) {
        var bean = new UpdateMagazineProcessImpl(service, genreService, publisherService);
        bean.setUpdateGenreProcess(this.updateGenreProcess);
        bean.setDeleteGenreProcess(this.deleteGenreProcess);
        bean.setUpdatePublisherProcess(this.updatePublisherProcess);
        bean.setDeletePublisherProcess(this.deletePublisherProcess);
        return bean;
    }

    @Bean
    public DeleteMagazineProcess deleteMagazineProcess(MagazineService service, GenreService genreService, PublisherService publisherService) {
        var bean = new DeleteMagazineProcessImpl(service, genreService, publisherService);
        bean.setDeleteGenreProcess(this.deleteGenreProcess);
        bean.setDeletePublisherProcess(this.deletePublisherProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateGenreProcess createGenreProcess;
    @Autowired
    @Lazy
    private UpdateGenreProcess updateGenreProcess;
    @Autowired
    @Lazy
    private CreatePublisherProcess createPublisherProcess;
    @Autowired
    @Lazy
    private UpdatePublisherProcess updatePublisherProcess;
    @Autowired
    @Lazy
    private DeleteGenreProcess deleteGenreProcess;
    @Autowired
    @Lazy
    private DeletePublisherProcess deletePublisherProcess;
}