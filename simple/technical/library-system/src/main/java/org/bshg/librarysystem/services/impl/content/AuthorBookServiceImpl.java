package org.bshg.librarysystem.services.impl.content;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.repository.content.AuthorBookDao;
import org.bshg.librarysystem.services.facade.content.AuthorBookService;
import org.bshg.librarysystem.services.facade.content.AuthorService;
import org.bshg.librarysystem.services.facade.content.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorBookServiceImpl implements AuthorBookService {
    //--------------- FIND -------------------------------------
    public AuthorBook findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<AuthorBook> findAll() {
        return dao.findAll();
    }

    public List<AuthorBook> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook create(AuthorBook item) {
        if (item == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<AuthorBook> create(List<AuthorBook> items) {
        List<AuthorBook> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook update(AuthorBook item) {
        if (item == null || item.getId() == null) return null;
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<AuthorBook> update(List<AuthorBook> items) {
        List<AuthorBook> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        AuthorBook item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(AuthorBook item) {
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<AuthorBook> items) {
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
    public int deleteByAuthorId(Long id) {
        if (id == null) return 0;
        return dao.deleteByAuthorId(id);
    }

    @Override
    public List<AuthorBook> findByAuthorId(Long id) {
        return dao.findByAuthorId(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByBookId(Long id) {
        if (id == null) return 0;
        return dao.deleteByBookId(id);
    }

    @Override
    public List<AuthorBook> findByBookId(Long id) {
        return dao.findByBookId(id);
    }

    //----------------------------------------------------------
//----------------------------------------------------------
    @Autowired
    private AuthorBookDao dao;
    @Lazy
    @Autowired
    private AuthorService authorService;
    @Lazy
    @Autowired
    private BookService bookService;
}