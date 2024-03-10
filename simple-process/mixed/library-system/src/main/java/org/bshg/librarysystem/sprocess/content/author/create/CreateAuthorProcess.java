package org.bshg.librarysystem.sprocess.content.author.create;

import org.bshg.librarysystem.entity.core.content.Author;

import java.util.List;

public interface CreateAuthorProcess {
    Author run(Author item);

    List<Author> run(List<Author> items);
}