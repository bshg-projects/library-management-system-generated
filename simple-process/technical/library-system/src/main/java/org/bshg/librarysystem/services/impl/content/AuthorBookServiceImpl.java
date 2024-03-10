package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.repository.content.AuthorBookDao;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    @Autowired
    AuthorBookDao dao;

    @Override
    public AuthorBook findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<AuthorBook> findAll() {
        return dao.findAll();
    }

    public List<AuthorBook> findAllOptimized() {
        return dao.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AuthorBook create(AuthorBook item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AuthorBook edit(AuthorBook item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(AuthorBook item) {
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
    public void delete(List<AuthorBook> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByAuthorId(Long id) {
        return dao.deleteByAuthorId(id);
    }

    @Override
    public List<AuthorBook> findByAuthorId(Long id) {
        return dao.findByAuthorId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        return dao.deleteByBookId(id);
    }

    @Override
    public List<AuthorBook> findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
}