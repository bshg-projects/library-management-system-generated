package org.bshg.librarysystem.sprocess.content.author.update;

import org.bshg.librarysystem.entity.core.content.Author;
import java.util.List;

public interface UpdateAuthorProcess {
    Author run(Author item);
    List<Author> run(List<Author> items);
}
