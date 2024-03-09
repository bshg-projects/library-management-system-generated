package org.bshg.librarysystem.sprocess.content.magazine.update;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.update.UpdateMagazineProcess;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.sprocess.content.genre.update.UpdateGenreProcess;
import org.bshg.librarysystem.sprocess.content.genre.delete.DeleteGenreProcess;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.sprocess.content.publisher.update.UpdatePublisherProcess;
import org.bshg.librarysystem.sprocess.content.publisher.delete.DeletePublisherProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateMagazineProcessImpl extends AbstractUpdateProcessImpl<Magazine, MagazineService> implements UpdateMagazineProcess {
public UpdateMagazineProcessImpl(MagazineService service, GenreService genreService, PublisherService publisherService) {
super(service);
this.genreService = genreService;
this.publisherService = publisherService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Magazine run(Magazine item) {
// Your Update Logic For 'Magazine'
item = service.edit(item);
return item;
}
private GenreService genreService;
private UpdateGenreProcess updateGenreProcess;
private DeleteGenreProcess deleteGenreProcess;
public void setUpdateGenreProcess(UpdateGenreProcess value) {
this.updateGenreProcess = value;
}
public void setDeleteGenreProcess(DeleteGenreProcess value) {
this.deleteGenreProcess = value;
}
private PublisherService publisherService;
private UpdatePublisherProcess updatePublisherProcess;
private DeletePublisherProcess deletePublisherProcess;
public void setUpdatePublisherProcess(UpdatePublisherProcess value) {
this.updatePublisherProcess = value;
}
public void setDeletePublisherProcess(DeletePublisherProcess value) {
this.deletePublisherProcess = value;
}
}