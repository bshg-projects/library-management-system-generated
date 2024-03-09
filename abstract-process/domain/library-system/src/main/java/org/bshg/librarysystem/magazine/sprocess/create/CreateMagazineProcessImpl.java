package org.bshg.librarysystem.magazine.sprocess.create;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.services.MagazineService;
import org.bshg.librarysystem.magazine.sprocess.create.CreateMagazineProcess;
import org.bshg.librarysystem.genre.services.GenreService;
import org.bshg.librarysystem.genre.sprocess.create.CreateGenreProcess;
import org.bshg.librarysystem.publisher.services.PublisherService;
import org.bshg.librarysystem.publisher.sprocess.create.CreatePublisherProcess;
import org.bshg.librarysystem.genre.Genre;
import org.bshg.librarysystem.publisher.Publisher;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateMagazineProcessImpl extends AbstractCreateProcessImpl<Magazine, MagazineService> implements CreateMagazineProcess {
public CreateMagazineProcessImpl(MagazineService service, GenreService genreService, PublisherService publisherService) {
super(service);
this.genreService = genreService;
this.publisherService = publisherService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Magazine run(Magazine item) {
// Your Insert Logic For 'Magazine'
item = service.create(item);
return item;
}
private GenreService genreService;
private CreateGenreProcess createGenreProcess;
public void setCreateGenreProcess(CreateGenreProcess value) {
this.createGenreProcess = value;
}
private PublisherService publisherService;
private CreatePublisherProcess createPublisherProcess;
public void setCreatePublisherProcess(CreatePublisherProcess value) {
this.createPublisherProcess = value;
}
}