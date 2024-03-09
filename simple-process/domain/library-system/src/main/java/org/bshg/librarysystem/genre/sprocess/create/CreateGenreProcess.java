package org.bshg.librarysystem.genre.sprocess.create;
import org.bshg.librarysystem.genre.Genre;
import java.util.List;
public interface CreateGenreProcess {
Genre run(Genre item);
List<Genre> run(List<Genre> items);
}