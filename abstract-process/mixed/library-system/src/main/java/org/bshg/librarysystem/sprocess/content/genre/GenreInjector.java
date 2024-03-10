package org.bshg.librarysystem.sprocess.content.genre;

import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.bookgenre.create.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.create.CreateGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.genre.update.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.update.UpdateGenreProcessImpl;
import org.bshg.librarysystem.sprocess.content.magazine.create.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Genre Processes (Create, Update, Delete).
 */
@Configuration
public class GenreInjector {
    @Bean
    public CreateGenreProcess createGenreProcess(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
        var bean = new CreateGenreProcessImpl(service, bookGenreService, magazineService);
        bean.setCreateBookGenreProcess(this.createBookGenreProcess);
        bean.setCreateMagazineProcess(this.createMagazineProcess);
        return bean;
    }

    @Bean
    public UpdateGenreProcess updateGenreProcess(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
        var bean = new UpdateGenreProcessImpl(service, bookGenreService, magazineService);
        bean.setUpdateBookGenreProcess(this.updateBookGenreProcess);
        bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
        bean.setUpdateMagazineProcess(this.updateMagazineProcess);
        bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
        return bean;
    }

    @Bean
    public DeleteGenreProcess deleteGenreProcess(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
        var bean = new DeleteGenreProcessImpl(service, bookGenreService, magazineService);
        bean.setDeleteMagazineProcess(this.deleteMagazineProcess);
        bean.setDeleteBookGenreProcess(this.deleteBookGenreProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateBookGenreProcess createBookGenreProcess;
    @Autowired
    @Lazy
    private UpdateBookGenreProcess updateBookGenreProcess;
    @Autowired
    @Lazy
    private CreateMagazineProcess createMagazineProcess;
    @Autowired
    @Lazy
    private UpdateMagazineProcess updateMagazineProcess;
    @Autowired
    @Lazy
    private DeleteMagazineProcess deleteMagazineProcess;
    @Autowired
    @Lazy
    private DeleteBookGenreProcess deleteBookGenreProcess;
}