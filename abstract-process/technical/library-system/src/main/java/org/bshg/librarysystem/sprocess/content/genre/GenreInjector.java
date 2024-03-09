package org.bshg.librarysystem.sprocess.content.genre;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.impl.CreateGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.genre.impl.UpdateGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.genre.impl.DeleteGenreProcessImpl;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.UpdateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.DeleteBookGenreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Genre Processes (Create, Update, Delete).
*/
@Configuration
public class GenreInjector {
@Bean
public CreateGenreProcess createGenreProcess (GenreService service,BookGenreService bookGenreService,MagazineService magazineService) {
var bean = new CreateGenreProcessImpl(service, bookGenreService, magazineService);
bean.setCreateBookGenreProcess(this.createBookGenreProcess);
bean.setCreateMagazineProcess(this.createMagazineProcess);
return bean;
}
@Bean
public UpdateGenreProcess updateGenreProcess (GenreService service,BookGenreService bookGenreService,MagazineService magazineService) {
var bean = new UpdateGenreProcessImpl(service,bookGenreService,magazineService);
bean.setUpdateBookGenreProcess(this.updateBookGenreProcess);
bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
bean.setUpdateMagazineProcess(this.updateMagazineProcess);
bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
return bean;
}
@Bean
public DeleteGenreProcess deleteGenreProcess(GenreService service,BookGenreService bookGenreService,MagazineService magazineService) {
var bean = new DeleteGenreProcessImpl(service,bookGenreService,magazineService);
bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
return bean;
}
@Autowired @Lazy private CreateBookGenreProcess createBookGenreProcess;
@Autowired @Lazy private UpdateBookGenreProcess updateBookGenreProcess;
@Autowired @Lazy private CreateMagazineProcess createMagazineProcess;
@Autowired @Lazy private UpdateMagazineProcess updateMagazineProcess;
@Autowired @Lazy private DeleteMagazineProcess deleteMagazineProcess;
@Autowired @Lazy private DeleteBookGenreProcess deleteBookGenreProcess;
}