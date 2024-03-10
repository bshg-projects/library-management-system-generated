package org.bshg.librarysystem.sprocess.content.genre.impl;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
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