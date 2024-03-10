package org.bshg.librarysystem.sprocess.content.bookgenre.impl;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateBookGenreProcessImpl extends AbstractCreateProcessImpl<BookGenre, BookGenreService> implements CreateBookGenreProcess {
    public CreateBookGenreProcessImpl(BookGenreService service, BookService bookService, GenreService genreService) {
        super(service);
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BookGenre run(BookGenre item) {
// Your Insert Logic For 'BookGenre'
        item = service.create(item);
        return item;
    }

    private BookService bookService;
    private CreateBookProcess createBookProcess;

    public void setCreateBookProcess(CreateBookProcess value) {
        this.createBookProcess = value;
    }

    private GenreService genreService;
    private CreateGenreProcess createGenreProcess;

    public void setCreateGenreProcess(CreateGenreProcess value) {
        this.createGenreProcess = value;
    }
}