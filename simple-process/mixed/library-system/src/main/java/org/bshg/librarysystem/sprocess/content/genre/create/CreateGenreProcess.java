package org.bshg.librarysystem.sprocess.content.genre.create;
import org.bshg.librarysystem.entity.core.content.Genre;
import java.util.List;
public interface CreateGenreProcess {
Genre run(Genre item);
List<Genre> run(List<Genre> items);
}