package org.bshg.librarysystem.services.content.author;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.repository.content.AuthorDao;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    //--------------- FIND -------------------------------------
    public Author findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Author> findAll() {
        return dao.findAll();
    }

    public List<Author> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Author create(Author item) {
        if (item == null) return null;
        Author saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Author> create(List<Author> items) {
        List<Author> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Author update(Author item) {
        if (item == null || item.getId() == null) return null;
        Author saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Author> update(List<Author> items) {
        List<Author> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Author item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Author item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Author> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Author item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Author::getAuthorBook, AuthorBook::setAuthor, authorBookService::create);
    }

    public void updateAssociatedList(Author item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, authorBookService.findByAuthorId(item.getId()),
                item.getAuthorBook(), AuthorBook::setAuthor,
                authorBookService::update,
                authorBookService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Author item) {
        deleteAssociatedList(item);
    }

    public void deleteAssociatedList(Author item) {
        authorBookService.deleteByAuthorId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private AuthorDao dao;
    @Lazy
    @Autowired
    private AuthorBookService authorBookService;
}