package org.bshg.librarysystem.sprocess.content.author.delete;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import java.util.List;
public interface DeleteAuthorProcess {
void run(Author item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Author> items);
}