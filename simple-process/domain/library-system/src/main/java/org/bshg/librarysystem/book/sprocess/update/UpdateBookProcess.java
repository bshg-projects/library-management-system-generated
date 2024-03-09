package org.bshg.librarysystem.book.sprocess.update;

import org.bshg.librarysystem.book.Book;
import java.util.List;

public interface UpdateBookProcess {
    Book run(Book item);
    List<Book> run(List<Book> items);
}
