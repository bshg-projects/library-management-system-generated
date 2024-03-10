package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.repository.content.BookGenreDao;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookGenreServiceImpl implements BookGenreService {
    @Autowired
    BookGenreDao dao;

    @Override
    public BookGenre findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<BookGenre> findAll() {
        return dao.findAll();
    }

    public List<BookGenre> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookGenre create(BookGenre item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookGenre edit(BookGenre item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(BookGenre item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<BookGenre> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        return dao.deleteByBookId(id);
    }

    @Override
    public List<BookGenre> findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByGenreId(Long id) {
        return dao.deleteByGenreId(id);
    }

    @Override
    public List<BookGenre> findByGenreId(Long id) {
        return dao.findByGenreId(id);
    }

    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
}