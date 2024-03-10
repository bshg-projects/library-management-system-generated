package org.bshg.librarysystem.webservice.content.genre;

import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.content.bookgenre.BookGenreConverter;
import org.bshg.librarysystem.webservice.content.magazine.MagazineConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter extends AbstractConverter<Genre, GenreDto> {
    @Autowired
    private BookGenreConverter bookGenreConverter;
    @Autowired
    private MagazineConverter magazineConverter;
    private boolean magazines = true;
    private boolean bookGenre = true;

    @Override
    protected void config() {
        config(Genre.class, GenreDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.bookGenreConverter.setGenre(value);
        this.magazineConverter.setGenre(value);
    }

    @Override
    protected Genre convertToItem(GenreDto dto) {
        var item = new Genre();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setMagazines(magazineConverter.toItem(dto.getMagazines()));
        item.setBookGenre(bookGenreConverter.toItem(dto.getBookGenre()));
        return item;
    }

    @Override
    protected GenreDto convertToDto(Genre item) {
        var dto = new GenreDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setMagazines(magazines ? magazineConverter.toDto(item.getMagazines()) : null);
        dto.setBookGenre(bookGenre ? bookGenreConverter.toDto(item.getBookGenre()) : null);
        return dto;
    }

    public void setMagazines(boolean value) {
        this.magazines = value;
    }

    public void setBookGenre(boolean value) {
        this.bookGenre = value;
    }

    public void setBookGenreConverter(BookGenreConverter value) {
        this.bookGenreConverter = value;
    }

    public BookGenreConverter getBookGenreConverter() {
        return bookGenreConverter;
    }

    public void setMagazineConverter(MagazineConverter value) {
        this.magazineConverter = value;
    }

    public MagazineConverter getMagazineConverter() {
        return magazineConverter;
    }
}