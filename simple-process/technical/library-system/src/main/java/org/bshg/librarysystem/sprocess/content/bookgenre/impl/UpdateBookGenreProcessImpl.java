package org.bshg.librarysystem.sprocess.content.bookgenre.impl;

import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.services.facade.content.BookGenreService;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.UpdateBookGenreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateBookGenreProcessImpl implements UpdateBookGenreProcess {
    @Transactional(rollbackFor = Exception.class)
    public BookGenre run(BookGenre item) { // Your Logic To Update 'BookGenre'
        item = service.edit(item);
        return item;
    }

    public List<BookGenre> run(List<BookGenre> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private BookGenreService service;
}