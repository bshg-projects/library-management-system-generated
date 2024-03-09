package org.bshg.librarysystem.sprocess.content.authorbook.delete;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.entity.core.content.Author;
import java.util.List;
public interface DeleteAuthorBookProcess {
void run(AuthorBook item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<AuthorBook> items);
void deleteByAuthor(Author author);
void deleteByBook(Book book);
}