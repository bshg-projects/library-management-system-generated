package org.bshg.librarysystem.genre.services;

import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.genre.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreDao dao;

    @Override
    public Genre findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Genre> findAll() {
        return dao.findAll();
    }

    public List<Genre> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Genre create(Genre item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Genre edit(Genre item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Genre item) {
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
    public void delete(List<Genre> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }
}