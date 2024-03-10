package org.bshg.librarysystem.sprocess.content.book.facade;

import org.bshg.librarysystem.entity.core.content.Book;

import java.util.List;

public interface UpdateBookProcess {
    Book run(Book item);

    List<Book> run(List<Book> items);
}
