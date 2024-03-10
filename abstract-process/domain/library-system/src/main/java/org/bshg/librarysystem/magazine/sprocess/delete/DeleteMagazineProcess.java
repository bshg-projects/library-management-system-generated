package org.bshg.librarysystem.magazine.sprocess.delete;

import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteMagazineProcess extends IDeleteProcess<Magazine> {
    void deleteByGenre(Genre genre);

    void deleteByPublisher(Publisher publisher);
}