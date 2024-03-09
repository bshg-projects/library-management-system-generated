package org.bshg.librarysystem.magazine.webservice;
import org.bshg.librarysystem.magazine.Magazine;
import org.bshg.librarysystem.magazine.webservice.MagazineDto;
import org.bshg.librarysystem.genre.webservice.GenreConverter;
import org.bshg.librarysystem.publisher.webservice.PublisherConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class MagazineConverter {
@Autowired private GenreConverter genreConverter;
@Autowired private PublisherConverter publisherConverter;
private boolean genre = true;
private boolean publisher = true;
protected void convertersConfig(boolean value) {
this.genreConverter.setMagazines(value);
this.publisherConverter.setMagazines(value);
}
public final MagazineDto toDto(Magazine item) {
this.convertersConfig(false);
var dto = item != null ? convertToDto(item) : null;
this.convertersConfig(true);
return dto;
}
public final Magazine toItem(MagazineDto d) {
return d != null ? convertToItem(d) : null;
}
public final List<Magazine> toItem(List<MagazineDto> dtos) {
if (dtos == null) return null;
List<Magazine> list = new ArrayList<>();
dtos.forEach(it -> list.add(toItem(it)));
return list;
}
public final List<MagazineDto> toDto(List<Magazine> items) {
if (items == null) return null;
List<MagazineDto> list = new ArrayList<>();
items.forEach(it -> list.add(toDto(it)));
return list;
}
protected Magazine convertToItem(MagazineDto dto) {
var item = new Magazine();
item.setId(dto.getId());
item.setTitle(dto.getTitle());
item.setPublicationDate(dto.getPublicationDate());
item.setGenre(genreConverter.toItem(dto.getGenre()));
item.setPublisher(publisherConverter.toItem(dto.getPublisher()));
return item;
}
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