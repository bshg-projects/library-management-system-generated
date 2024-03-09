
package org.bshg.librarysystem.genre.services;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.GenreDao;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.services.BookGenreService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class GenreServiceImpl extends ServiceImpl<Genre, GenreDao> implements GenreService {
public GenreServiceImpl(GenreDao dao) {
super(dao);
}
@Override
public List<Genre> findAllOptimized() {
return dao.findAllOptimized();
}
@Override
public void deleteAssociatedList(Genre item) {
if (item == null || item.getId() == null) return;
magazineService.deleteByGenreId(item.getId());
bookGenreService.deleteByGenreId(item.getId());
}
@Override
public void createAssociatedList(Genre item) {
if (item == null || item.getId() == null) return;
ServiceHelper.createList(item, Genre::getMagazines, Magazine::setGenre, magazineService);
ServiceHelper.createList(item, Genre::getBookGenre, BookGenre::setGenre, bookGenreService);
}
@Override
public void updateAssociatedList(Genre item) {
if (item == null || item.getId() == null) return;
ServiceHelper.updateList(item,magazineService::findByGenreId,Genre::getMagazines,Magazine::setGenre,magazineService);
ServiceHelper.updateList(item,bookGenreService::findByGenreId,Genre::getBookGenre,BookGenre::setGenre,bookGenreService);
}
@Lazy @Autowired private MagazineService magazineService;
@Lazy @Autowired private BookGenreService bookGenreService;
}