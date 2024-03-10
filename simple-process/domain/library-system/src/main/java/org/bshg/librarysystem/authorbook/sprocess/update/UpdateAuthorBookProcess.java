package org.bshg.librarysystem.authorbook.sprocess.update;

import org.bshg.librarysystem.authorbook.AuthorBook;

import java.util.List;

public interface UpdateAuthorBookProcess {
    AuthorBook run(AuthorBook item);

    List<AuthorBook> run(List<AuthorBook> items);
}
