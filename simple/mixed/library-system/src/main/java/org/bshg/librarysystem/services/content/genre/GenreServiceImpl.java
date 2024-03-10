package org.bshg.librarysystem.services.content.genre;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.repository.content.GenreDao;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    //--------------- FIND -------------------------------------
    public Genre findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Genre> findAll() {
        return dao.findAll();
    }

    public List<Genre> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Genre create(Genre item) {
        if (item == null) return null;
        Genre saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Genre> create(List<Genre> items) {
        List<Genre> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Genre update(Genre item) {
        if (item == null || item.getId() == null) return null;
        Genre saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Genre> update(List<Genre> items) {
        List<Genre> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Genre item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Genre item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Genre> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Genre item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Genre item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Genre::getMagazines, Magazine::setGenre, magazineService::create);
        ServiceHelper.createList(item, Genre::getBookGenre, BookGenre::setGenre, bookGenreService::create);
    }

    public void updateAssociatedList(Genre item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, magazineService.findByGenreId(item.getId()),
                item.getMagazines(), Magazine::setGenre,
                magazineService::update,
                magazineService::delete
        );
        ServiceHelper.updateList(
                item, bookGenreService.findByGenreId(item.getId()),
                item.getBookGenre(), BookGenre::setGenre,
                bookGenreService::update,
                bookGenreService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Genre item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Genre item) {
        magazineService.deleteByGenreId(item.getId());
        bookGenreService.deleteByGenreId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private GenreDao dao;
    @Lazy
    @Autowired
    private MagazineService magazineService;
    @Lazy
    @Autowired
    private BookGenreService bookGenreService;
}