
package org.bshg.librarysystem.sprocess.content.genre.delete;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcess;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.delete.DeleteMagazineProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.delete.DeleteBookGenreProcess;
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