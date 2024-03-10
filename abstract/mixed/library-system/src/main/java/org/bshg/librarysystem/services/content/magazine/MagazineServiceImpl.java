package org.bshg.librarysystem.services.content.magazine;

import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.repository.content.MagazineDao;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MagazineServiceImpl extends ServiceImpl<Magazine, MagazineDao> implements MagazineService {
    public MagazineServiceImpl(MagazineDao dao) {
        super(dao);
    }

    @Override
    public List<Magazine> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByGenreId(Long id) {
        if (id == null) return 0;
        return dao.deleteByGenreId(id);
    }

    @Override
    public List<Magazine> findByGenreId(Long id) {
        return dao.findByGenreId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPublisherId(Long id) {
        if (id == null) return 0;
        return dao.deleteByPublisherId(id);
    }

    @Override
    public List<Magazine> findByPublisherId(Long id) {
        return dao.findByPublisherId(id);
    }

    @Lazy
    @Autowired
    private GenreService genreService;
    @Lazy
    @Autowired
    private PublisherService publisherService;
}