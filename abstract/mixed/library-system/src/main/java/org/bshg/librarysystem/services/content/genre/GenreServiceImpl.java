package org.bshg.librarysystem.services.content.genre;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.repository.content.GenreDao;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
        ServiceHelper.updateList(item, magazineService::findByGenreId, Genre::getMagazines, Magazine::setGenre, magazineService);
        ServiceHelper.updateList(item, bookGenreService::findByGenreId, Genre::getBookGenre, BookGenre::setGenre, bookGenreService);
    }

    @Lazy
    @Autowired
    private MagazineService magazineService;
    @Lazy
    @Autowired
    private BookGenreService bookGenreService;
}