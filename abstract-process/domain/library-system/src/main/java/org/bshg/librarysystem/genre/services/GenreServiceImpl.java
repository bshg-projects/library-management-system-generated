package org.bshg.librarysystem.genre.services;

import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.GenreDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
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
}