package org.bshg.librarysystem.author.sprocess.create;
import org.bshg.librarysystem.author.Author;
import java.util.List;
public interface CreateAuthorProcess {
Author run(Author item);
List<Author> run(List<Author> items);
}