package org.bshg.librarysystem.magazine.services;

import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.MagazineDao;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {
    //--------------- FIND -------------------------------------
    public Magazine findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Magazine> findAll() {
        return dao.findAll();
    }

    public List<Magazine> findAllOptimized() {
        return dao.findAllOptimized();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Magazine create(Magazine item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Magazine> create(List<Magazine> items) {
        List<Magazine> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Magazine update(Magazine item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Magazine> update(List<Magazine> items) {
        List<Magazine> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Magazine item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Magazine item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Magazine> items) {
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

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private MagazineDao dao;
    @Lazy
    @Autowired
    private GenreService genreService;
    @Lazy
    @Autowired
    private PublisherService publisherService;
}