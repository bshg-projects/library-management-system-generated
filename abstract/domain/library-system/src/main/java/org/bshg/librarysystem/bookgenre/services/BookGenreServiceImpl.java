package org.bshg.librarysystem.bookgenre.services;

import org.bshg.librarysystem.book.services.BookService;
import org.bshg.librarysystem.bookgenre.BookGenre;
import org.bshg.librarysystem.bookgenre.BookGenreDao;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookGenreServiceImpl extends ServiceImpl<BookGenre, BookGenreDao> implements BookGenreService {
    public BookGenreServiceImpl(BookGenreDao dao) {
        super(dao);
    }

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

    @Lazy
    @Autowired
    private BookService bookService;
    @Lazy
    @Autowired
    private GenreService genreService;
}