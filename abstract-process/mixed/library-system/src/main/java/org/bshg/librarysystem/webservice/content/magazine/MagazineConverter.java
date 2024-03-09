package org.bshg.librarysystem.webservice.content.magazine;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.webservice.content.magazine.MagazineDto;
import org.bshg.librarysystem.webservice.content.genre.GenreConverter;
import org.bshg.librarysystem.webservice.content.publisher.PublisherConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MagazineConverter extends AbstractConverter<Magazine, MagazineDto> {
@Autowired private GenreConverter genreConverter;
@Autowired private PublisherConverter publisherConverter;
private boolean genre = true;
private boolean publisher = true;
@Override
protected void convertersConfig(boolean value) {
this.genreConverter.setMagazines(value);
this.publisherConverter.setMagazines(value);
}
@Override
protected Magazine convertToItem(MagazineDto dto) {
var item = new Magazine();
item.setId(dto.getId());
item.setTitle(dto.getTitle());
item.setPublicationDate(dto.getPublicationDate());
item.setGenre(genreConverter.toItem(dto.getGenre()));
item.setPublisher(publisherConverter.toItem(dto.getPublisher()));
return item;
}
@Override
protected MagazineDto convertToDto(Magazine item) {
var dto = new MagazineDto();
dto.setId(item.getId());
dto.setTitle(item.getTitle());
dto.setPublicationDate(item.getPublicationDate());
dto.setGenre(genre? genreConverter.toDto(item.getGenre()): null);
dto.setPublisher(publisher? publisherConverter.toDto(item.getPublisher()): null);
return dto;
}
public void setGenre(boolean value) {
this.genre = value;
}
public void setPublisher(boolean value) {
this.publisher = value;
}
public void setGenreConverter(GenreConverter value) {
this.genreConverter = value;
}
public GenreConverter getGenreConverter() {
return genreConverter;
}
public void setPublisherConverter(PublisherConverter value) {
this.publisherConverter = value;
}
public PublisherConverter getPublisherConverter() {
return publisherConverter;
}
}