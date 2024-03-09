package org.bshg.librarysystem.author.sprocess.delete;
import org.bshg.librarysystem.author.Author;
import org.bshg.librarysystem.authorbook.AuthorBook;
import java.util.List;
public interface DeleteAuthorProcess {
void run(Author item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Author> items);
}