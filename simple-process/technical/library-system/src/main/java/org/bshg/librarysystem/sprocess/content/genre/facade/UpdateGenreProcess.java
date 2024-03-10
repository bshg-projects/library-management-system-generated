package org.bshg.librarysystem.sprocess.content.genre.facade;

import org.bshg.librarysystem.entity.core.content.Genre;

import java.util.List;

public interface UpdateGenreProcess {
    Genre run(Genre item);

    List<Genre> run(List<Genre> items);
}
