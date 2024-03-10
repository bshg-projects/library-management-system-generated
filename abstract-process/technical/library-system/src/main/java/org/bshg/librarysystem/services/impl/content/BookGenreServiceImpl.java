package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.repository.content.BookGenreDao;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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