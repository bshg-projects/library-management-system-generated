package org.bshg.librarysystem.genre.sprocess;

import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcessImpl;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcessImpl;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcess;
import org.bshg.librarysystem.genre.sprocess.update.UpdateGenreProcessImpl;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
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