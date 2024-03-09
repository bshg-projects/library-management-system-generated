package org.bshg.librarysystem.webservice.content.genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.content.bookgenre.BookGenreDto;
import org.bshg.librarysystem.webservice.content.magazine.MagazineDto;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreDto extends AuditBaseDto {
public GenreDto() {
super();
}
private String name;
private List<MagazineDto> magazines;
private List<BookGenreDto> bookGenre;
public String getName() {
return name;
}
public void setName(String value) {
this.name = value;
}
public List<MagazineDto> getMagazines() {
return magazines;
}
public void setMagazines(List<MagazineDto> value) {
this.magazines = value;
}
public List<BookGenreDto> getBookGenre() {
return bookGenre;
}
public void setBookGenre(List<BookGenreDto> value) {
this.bookGenre = value;
}
}