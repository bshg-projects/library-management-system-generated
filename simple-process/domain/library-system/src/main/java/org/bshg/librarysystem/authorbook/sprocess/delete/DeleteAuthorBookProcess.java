package org.bshg.librarysystem.authorbook.sprocess.delete;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.book.Book;
import org.bshg.librarysystem.author.Author;
import java.util.List;
public interface DeleteAuthorBookProcess {
void run(AuthorBook item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<AuthorBook> items);
void deleteByAuthor(Author author);
void deleteByBook(Book book);
}