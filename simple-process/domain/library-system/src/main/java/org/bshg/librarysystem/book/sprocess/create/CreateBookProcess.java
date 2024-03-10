package org.bshg.librarysystem.book.sprocess.create;

import org.bshg.librarysystem.book.Book;

import java.util.List;

public interface CreateBookProcess {
    Book run(Book item);

    List<Book> run(List<Book> items);
}