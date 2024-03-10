package org.bshg.librarysystem.sprocess.content.book.create;

import org.bshg.librarysystem.entity.core.content.Book;

import java.util.List;

public interface CreateBookProcess {
    Book run(Book item);

    List<Book> run(List<Book> items);
}