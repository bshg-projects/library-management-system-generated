package org.bshg.librarysystem.sprocess.content.bookgenre.impl;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.book.facade.DeleteBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.UpdateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.DeleteGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.UpdateGenreProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateBookGenreProcessImpl extends AbstractUpdateProcessImpl<BookGenre, BookGenreService> implements UpdateBookGenreProcess {
    public UpdateBookGenreProcessImpl(BookGenreService service, BookService bookService, GenreService genreService) {
        super(service);
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BookGenre run(BookGenre item) {
// Your Update Logic For 'BookGenre'
        item = service.edit(item);
        return item;
    }

    private BookService bookService;
    private UpdateBookProcess updateBookProcess;
    private DeleteBookProcess deleteBookProcess;

    public void setUpdateBookProcess(UpdateBookProcess value) {
        this.updateBookProcess = value;
    }

    public void setDeleteBookProcess(DeleteBookProcess value) {
        this.deleteBookProcess = value;
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
}