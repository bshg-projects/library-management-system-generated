package org.bshg.librarysystem.genre.sprocess.delete;

import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DeleteGenreProcessImpl implements DeleteGenreProcess {
    private void process(Genre item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Genre item) {
        process(item);
        deleteAssociated(item);
        service.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(Long id) {
        Genre item = service.findById(id);
        if (item != null) run(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void runByIds(List<Long> ids) {
        ids.forEach(id -> {
            Genre item = service.findById(id);
            if (item != null) {
                process(item);
                deleteAssociated(item);
            }
        });
        service.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void run(List<Genre> items) {
        items.forEach(this::process);
        items.forEach(this::deleteAssociated);
        service.delete(items);
    }

    @Transactional(rollbackFor = Exception.class)
    protected void deleteAssociated(Genre item) {
        if (item == null || item.getId() == null) return;
        deleteAssociatedList(item);
    }

    private void deleteAssociatedList(Genre item) {
        deleteMagazineProcess.deleteByGenre(item);
        deleteBookGenreProcess.deleteByGenre(item);
    }

    @Autowired
    private GenreService service;
    @Autowired
    @Lazy
    private BookGenreService bookGenreService;
    @Autowired
    @Lazy
    private MagazineService magazineService;
    @Autowired
    @Lazy
    private DeleteMagazineProcess deleteMagazineProcess;
    @Autowired
    @Lazy
    private DeleteBookGenreProcess deleteBookGenreProcess;
}