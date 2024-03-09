package org.bshg.librarysystem.sprocess.content.authorbook.update;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import java.util.List;

public interface UpdateAuthorBookProcess {
    AuthorBook run(AuthorBook item);
    List<AuthorBook> run(List<AuthorBook> items);
}
