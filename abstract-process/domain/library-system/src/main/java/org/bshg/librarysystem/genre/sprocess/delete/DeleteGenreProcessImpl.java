
package org.bshg.librarysystem.genre.sprocess.delete;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.delete.DeleteGenreProcess;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.bookgenre.sprocess.delete.DeleteBookGenreProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteGenreProcessImpl extends AbstractDeleteProcessImpl<Genre, GenreService> implements DeleteGenreProcess {
public DeleteGenreProcessImpl(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
super(service);
this.bookGenreService = bookGenreService;
this.magazineService = magazineService;
}
@Override
protected void process(Genre item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Override
public void deleteAssociatedList(Genre item) {
deleteMagazineProcess.deleteByGenre(item);
deleteBookGenreProcess.deleteByGenre(item);
}
private BookGenreService bookGenreService;
private MagazineService magazineService;
private DeleteMagazineProcess deleteMagazineProcess;
public void setDeleteMagazineProcess(DeleteMagazineProcess value) {
this.deleteMagazineProcess = value;
}
private DeleteBookGenreProcess deleteBookGenreProcess;
public void setDeleteBookGenreProcess(DeleteBookGenreProcess value) {
this.deleteBookGenreProcess = value;
}
}