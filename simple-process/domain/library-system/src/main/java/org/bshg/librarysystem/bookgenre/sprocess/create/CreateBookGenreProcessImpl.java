package org.bshg.librarysystem.bookgenre.sprocess.create;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.book.sprocess.create.CreateBookProcess;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateBookGenreProcessImpl implements CreateBookGenreProcess {
    @Transactional(rollbackFor = Exception.class)
    public BookGenre run(BookGenre item) {
// Your Creation Logic For 'BookGenre'
        item = service.create(item);
        return item;
    }

    public List<BookGenre> run(List<BookGenre> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private BookGenreService service;
    @Autowired
    private BookService bookService;
    @Autowired
    @Lazy
    private CreateBookProcess createBookProcess;
    @Autowired
    private GenreService genreService;
    @Autowired
    @Lazy
    private CreateGenreProcess createGenreProcess;
}