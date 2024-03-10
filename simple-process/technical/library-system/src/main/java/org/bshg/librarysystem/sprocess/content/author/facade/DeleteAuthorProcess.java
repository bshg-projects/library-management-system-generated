package org.bshg.librarysystem.sprocess.content.author.facade;

import org.bshg.librarysystem.entity.core.content.Author;

import java.util.List;

public interface DeleteAuthorProcess {
    void run(Author item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Author> items);
}