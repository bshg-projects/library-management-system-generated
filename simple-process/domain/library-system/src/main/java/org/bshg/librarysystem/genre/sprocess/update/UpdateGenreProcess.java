package org.bshg.librarysystem.genre.sprocess.update;

import org.bshg.librarysystem.genre.Genre;
import java.util.List;

public interface UpdateGenreProcess {
    Genre run(Genre item);
    List<Genre> run(List<Genre> items);
}
