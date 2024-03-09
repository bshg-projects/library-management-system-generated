package org.bshg.librarysystem.author.sprocess.update;

import org.bshg.librarysystem.author.Author;
import java.util.List;

public interface UpdateAuthorProcess {
    Author run(Author item);
    List<Author> run(List<Author> items);
}
