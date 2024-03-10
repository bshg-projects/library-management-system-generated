package org.bshg.librarysystem.webservice.content.author;

import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.content.authorbook.AuthorBookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter extends AbstractConverter<Author, AuthorDto> {
    @Autowired
    private AuthorBookConverter authorBookConverter;
    private boolean authorBook = true;

    @Override
    protected void config() {
        config(Author.class, AuthorDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.authorBookConverter.setAuthor(value);
    }

    @Override
    protected Author convertToItem(AuthorDto dto) {
        var item = new Author();
        item.setId(dto.getId());
        item.setFirstName(dto.getFirstName());
        item.setLastName(dto.getLastName());
        item.setDateOfBirth(dto.getDateOfBirth());
        item.setNationality(dto.getNationality());
        item.setBiography(dto.getBiography());
        item.setAuthorBook(authorBookConverter.toItem(dto.getAuthorBook()));
        return item;
    }

    @Override
    protected AuthorDto convertToDto(Author item) {
        var dto = new AuthorDto();
        dto.setId(item.getId());
        dto.setFirstName(item.getFirstName());
        dto.setLastName(item.getLastName());
        dto.setDateOfBirth(item.getDateOfBirth());
        dto.setNationality(item.getNationality());
        dto.setBiography(item.getBiography());
        dto.setAuthorBook(authorBook ? authorBookConverter.toDto(item.getAuthorBook()) : null);
        return dto;
    }

    public void setAuthorBook(boolean value) {
        this.authorBook = value;
    }

    public void setAuthorBookConverter(AuthorBookConverter value) {
        this.authorBookConverter = value;
    }

    public AuthorBookConverter getAuthorBookConverter() {
        return authorBookConverter;
    }
}