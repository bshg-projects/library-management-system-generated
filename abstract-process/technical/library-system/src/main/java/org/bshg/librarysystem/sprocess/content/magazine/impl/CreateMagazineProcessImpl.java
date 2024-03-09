package org.bshg.librarysystem.sprocess.content.magazine.impl;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.facade.content.MagazineService;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.services.facade.content.GenreService;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.services.facade.content.PublisherService;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.entity.core.content.Publisher;
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