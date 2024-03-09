package org.bshg.librarysystem.sprocess.content.genre.impl;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateGenreProcessImpl extends AbstractCreateProcessImpl<Genre, GenreService> implements CreateGenreProcess {
public CreateGenreProcessImpl(GenreService service, BookGenreService bookGenreService, MagazineService magazineService) {
super(service);
this.bookGenreService = bookGenreService;
this.magazineService = magazineService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Genre run(Genre item) {
// Your Insert Logic For 'Genre'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Genre item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Genre::getMagazines, Magazine::setGenre, createMagazineProcess);
ProcessHelper.createList(item, Genre::getBookGenre, BookGenre::setGenre, createBookGenreProcess);
}
private BookGenreService bookGenreService;
private CreateBookGenreProcess createBookGenreProcess;
public void setCreateBookGenreProcess(CreateBookGenreProcess value) {
this.createBookGenreProcess = value;
}
private MagazineService magazineService;
private CreateMagazineProcess createMagazineProcess;
public void setCreateMagazineProcess(CreateMagazineProcess value) {
this.createMagazineProcess = value;
}
}