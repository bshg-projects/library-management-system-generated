package org.bshg.librarysystem.genre.sprocess.create;

import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.create.CreateBookGenreProcess;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateGenreProcessImpl implements CreateGenreProcess {
    @Transactional(rollbackFor = Exception.class)
    public Genre run(Genre item) {
// Your Creation Logic For 'Genre'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Genre> run(List<Genre> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Genre item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Genre::getMagazines, Magazine::setGenre, createMagazineProcess::run);
        ProcessHelper.createList(item, Genre::getBookGenre, BookGenre::setGenre, createBookGenreProcess::run);
    }

    @Autowired
    private GenreService service;
    @Autowired
    private BookGenreService bookGenreService;
    @Autowired
    @Lazy
    private CreateBookGenreProcess createBookGenreProcess;
    @Autowired
    private MagazineService magazineService;
    @Autowired
    @Lazy
    private CreateMagazineProcess createMagazineProcess;
}