package org.bshg.librarysystem.genre.sprocess.delete;

import org.bshg.librarysystem.genre.Genre;

import java.util.List;

public interface DeleteGenreProcess {
    void run(Genre item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Genre> items);
}