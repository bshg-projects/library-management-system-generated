package org.bshg.librarysystem.sprocess.content.bookgenre.impl;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
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