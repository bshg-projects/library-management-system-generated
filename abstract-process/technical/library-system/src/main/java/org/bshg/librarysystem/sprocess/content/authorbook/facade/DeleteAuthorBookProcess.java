package org.bshg.librarysystem.sprocess.content.authorbook.facade;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Author;
public interface DeleteAuthorBookProcess extends IDeleteProcess<AuthorBook> {
void deleteByAuthor(Author author);
void deleteByBook(Book book);
}