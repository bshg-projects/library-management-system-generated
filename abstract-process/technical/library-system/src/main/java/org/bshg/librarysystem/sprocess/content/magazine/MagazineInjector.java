package org.bshg.librarysystem.sprocess.content.magazine;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.impl.CreateMagazineProcessImpl;
import org.bshg.librarysystem.sprocess.content.magazine.impl.UpdateMagazineProcessImpl;
import org.bshg.librarysystem.sprocess.content.magazine.impl.DeleteMagazineProcessImpl;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.UpdateGenreProcess;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.DeletePublisherProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Magazine Processes (Create, Update, Delete).
*/
@Configuration
public class MagazineInjector {
@Bean
public CreateMagazineProcess createMagazineProcess (MagazineService service,GenreService genreService,PublisherService publisherService) {
var bean = new CreateMagazineProcessImpl(service, genreService, publisherService);
bean.setCreateGenreProcess(this.createGenreProcess);
bean.setCreatePublisherProcess(this.createPublisherProcess);
return bean;
}
@Bean
public UpdateMagazineProcess updateMagazineProcess (MagazineService service,GenreService genreService,PublisherService publisherService) {
var bean = new UpdateMagazineProcessImpl(service,genreService,publisherService);
bean.setUpdateGenreProcess(this.updateGenreProcess);
bean.setDeleteGenreProcess(this.deleteGenreProcess);
bean.setUpdatePublisherProcess(this.updatePublisherProcess);
bean.setDeletePublisherProcess(this.deletePublisherProcess);
return bean;
}
@Bean
public DeleteMagazineProcess deleteMagazineProcess(MagazineService service,GenreService genreService,PublisherService publisherService) {
var bean = new DeleteMagazineProcessImpl(service,genreService,publisherService);
bean.setDeleteGenreProcess(this.deleteGenreProcess);
bean.setDeletePublisherProcess(this.deletePublisherProcess);
return bean;
}
@Autowired @Lazy private CreateGenreProcess createGenreProcess;
@Autowired @Lazy private UpdateGenreProcess updateGenreProcess;
@Autowired @Lazy private CreatePublisherProcess createPublisherProcess;
@Autowired @Lazy private UpdatePublisherProcess updatePublisherProcess;
@Autowired @Lazy private DeleteGenreProcess deleteGenreProcess;
@Autowired @Lazy private DeletePublisherProcess deletePublisherProcess;
}