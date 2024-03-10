package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.repository.content.BookGenreDao;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookGenreServiceImpl implements BookGenreService {
    //--------------- FIND -------------------------------------
    public BookGenre findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<BookGenre> findAll() {
        return dao.findAll();
    }

    public List<BookGenre> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public BookGenre create(BookGenre item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<BookGenre> create(List<BookGenre> items) {
        List<BookGenre> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public BookGenre update(BookGenre item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<BookGenre> update(List<BookGenre> items) {
        List<BookGenre> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        BookGenre item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(BookGenre item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<BookGenre> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        if (id == null) return 0;
        return dao.deleteByBookId(id);
    }

    @Override
    public List<BookGenre> findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByGenreId(Long id) {
        if (id == null) return 0;
        return dao.deleteByGenreId(id);
    }

    @Override
    public List<BookGenre> findByGenreId(Long id) {
        return dao.findByGenreId(id);
    }

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private BookGenreDao dao;
    @Lazy
    @Autowired
    private BookService bookService;
    @Lazy
    @Autowired
    private GenreService genreService;
}