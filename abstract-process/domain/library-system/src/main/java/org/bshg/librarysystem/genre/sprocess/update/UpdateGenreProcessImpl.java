package org.bshg.librarysystem.genre.sprocess.update;

import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.bookgenre.sprocess.update.UpdateBookGenreProcess;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.magazine.sprocess.update.UpdateMagazineProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class UpdateGenreProcessImpl extends AbstractUpdateProcessImpl<Genre, GenreService> implements UpdateGenreProcess {
    public UpdateGenreProcessImpl(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
        super(service);
        this.bookGenreService = bookGenreService;
        this.magazineService = magazineService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Genre run(Genre item) {
// Your Update Logic For 'Genre'
        item = service.edit(item);
        updateAssociatedList(item);
        return item;
    }

    @Override
    public void updateAssociatedList(Genre item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.updateList(
                item,
                magazineService::findByGenreId,
                Genre::getMagazines,
                Magazine::setGenre,
                updateMagazineProcess,
                deleteMagazineProcess
        );
        ProcessHelper.updateList(
                item,
                bookGenreService::findByGenreId,
                Genre::getBookGenre,
                BookGenre::setGenre,
                updateBookGenreProcess,
                deleteBookGenreProcess
        );
    }

    private BookGenreService bookGenreService;
    private UpdateBookGenreProcess updateBookGenreProcess;
    private DeleteBookGenreProcess deleteBookGenreProcess;

    public void setUpdateBookGenreProcess(UpdateBookGenreProcess value) {
        this.updateBookGenreProcess = value;
    }

    public void setDeleteBookGenreProcess(DeleteBookGenreProcess value) {
        this.deleteBookGenreProcess = value;
    }

    private MagazineService magazineService;
    private UpdateMagazineProcess updateMagazineProcess;
    private DeleteMagazineProcess deleteMagazineProcess;

    public void setUpdateMagazineProcess(UpdateMagazineProcess value) {
        this.updateMagazineProcess = value;
    }

    public void setDeleteMagazineProcess(DeleteMagazineProcess value) {
        this.deleteMagazineProcess = value;
    }
}