package org.bshg.librarysystem.sprocess.content.magazine.facade;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Publisher;
public interface DeleteMagazineProcess extends IDeleteProcess<Magazine> {
void deleteByGenre(Genre genre);
void deleteByPublisher(Publisher publisher);
}