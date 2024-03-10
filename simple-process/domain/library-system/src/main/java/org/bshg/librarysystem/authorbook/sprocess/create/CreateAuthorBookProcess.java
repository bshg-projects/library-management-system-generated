package org.bshg.librarysystem.authorbook.sprocess.create;

import org.bshg.librarysystem.authorbook.AuthorBook;

import java.util.List;

public interface CreateAuthorBookProcess {
    AuthorBook run(AuthorBook item);

    List<AuthorBook> run(List<AuthorBook> items);
}