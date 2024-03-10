package org.bshg.librarysystem.authorbook.sprocess.delete;

import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteAuthorBookProcess extends IDeleteProcess<AuthorBook> {
    void deleteByAuthor(Author author);

    void deleteByBook(Book book);
}