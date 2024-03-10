package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.repository.content.AuthorDao;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDao dao;

    @Override
    public Author findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return dao.findAll();
    }

    public List<Author> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Author create(Author item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Author edit(Author item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Author item) {
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
    public void delete(List<Author> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }
}