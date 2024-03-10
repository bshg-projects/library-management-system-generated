package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.repository.content.GenreDao;
import org.bshg.librarysystem.services.facade.content.GenreService;
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