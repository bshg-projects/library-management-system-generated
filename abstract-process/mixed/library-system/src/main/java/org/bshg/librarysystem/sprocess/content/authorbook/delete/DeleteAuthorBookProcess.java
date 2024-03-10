package org.bshg.librarysystem.sprocess.content.authorbook.delete;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteAuthorBookProcess extends IDeleteProcess<AuthorBook> {
    void deleteByAuthor(Author author);

    void deleteByBook(Book book);
}