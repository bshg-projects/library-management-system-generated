package org.bshg.librarysystem.authorbook.sprocess.update;

import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.authorbook.services.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateAuthorBookProcessImpl implements UpdateAuthorBookProcess {
    @Transactional(rollbackFor = Exception.class)
    public AuthorBook run(AuthorBook item) { // Your Logic To Update 'AuthorBook'
        item = service.edit(item);
        return item;
    }

    public List<AuthorBook> run(List<AuthorBook> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private AuthorBookService service;
}