package org.bshg.librarysystem.sprocess.content.genre.delete;

import org.bshg.librarysystem.entity.core.content.Genre;

import java.util.List;

public interface DeleteGenreProcess {
    void run(Genre item);

    void run(Long id);

    void runByIds(List<Long> ids);

    void run(List<Genre> items);
}