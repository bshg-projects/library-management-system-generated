package org.bshg.librarysystem.magazine.sprocess;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcessImpl;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcessImpl;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcessImpl;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.publisher.sprocess.update.UpdatePublisherProcess;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.publisher.sprocess.delete.DeletePublisherProcess;
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