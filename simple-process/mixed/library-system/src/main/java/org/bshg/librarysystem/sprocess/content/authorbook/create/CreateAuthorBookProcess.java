package org.bshg.librarysystem.sprocess.content.authorbook.create;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import java.util.List;
public interface CreateAuthorBookProcess {
AuthorBook run(AuthorBook item);
List<AuthorBook> run(List<AuthorBook> items);
}