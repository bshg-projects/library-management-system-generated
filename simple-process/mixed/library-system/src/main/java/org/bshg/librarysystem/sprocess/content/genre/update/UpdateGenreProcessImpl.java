package org.bshg.librarysystem.sprocess.content.genre.update;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateGenreProcessImpl implements UpdateGenreProcess {
    @Transactional(rollbackFor = Exception.class)
    public Genre run(Genre item) { // Your Logic To Update 'Genre'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    public List<Genre> run(List<Genre> items) {
        items.forEach(this::run);
        return items;
    }

    public void updateAssociatedList(Genre item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                magazineService.findByGenreId(item.getId()),
                item.getMagazines(),
                Magazine::setGenre,
                updateMagazineProcess::run,
                deleteMagazineProcess::run
        );
        ProcessHelper.updateList(
                item,
                bookGenreService.findByGenreId(item.getId()),
                item.getBookGenre(),
                BookGenre::setGenre,
                updateBookGenreProcess::run,
                deleteBookGenreProcess::run
        );
    }

    @Autowired
    private GenreService service;
    @Autowired
    MagazineService magazineService;
    @Autowired
    @Lazy
    private UpdateMagazineProcess updateMagazineProcess;
    @Autowired
    @Lazy
    private DeleteMagazineProcess deleteMagazineProcess;
    @Autowired
    BookGenreService bookGenreService;
    @Autowired
    @Lazy
    private UpdateBookGenreProcess updateBookGenreProcess;
    @Autowired
    @Lazy
    private DeleteBookGenreProcess deleteBookGenreProcess;
}