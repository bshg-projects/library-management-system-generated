package org.bshg.librarysystem.webservice.converter.content;

import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.dto.content.AuthorBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorBookConverter extends AbstractConverter<AuthorBook, AuthorBookDto> {
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private AuthorConverter authorConverter;
    private boolean author = true;
    private boolean book = true;

    @Override
    protected void config() {
        config(AuthorBook.class, AuthorBookDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.bookConverter.setAuthorBook(value);
        this.authorConverter.setAuthorBook(value);
    }

    @Override
    protected AuthorBook convertToItem(AuthorBookDto dto) {
        var item = new AuthorBook();
        item.setId(dto.getId());
        item.setContribution(dto.getContribution());
        item.setRole(dto.getRole());
        item.setAuthor(authorConverter.toItem(dto.getAuthor()));
        item.setBook(bookConverter.toItem(dto.getBook()));
        return item;
    }

    @Override
    protected AuthorBookDto convertToDto(AuthorBook item) {
        var dto = new AuthorBookDto();
        dto.setId(item.getId());
        dto.setContribution(item.getContribution());
        dto.setRole(item.getRole());
        dto.setAuthor(author ? authorConverter.toDto(item.getAuthor()) : null);
        dto.setBook(book ? bookConverter.toDto(item.getBook()) : null);
        return dto;
    }

    public void setAuthor(boolean value) {
        this.author = value;
    }

    public void setBook(boolean value) {
        this.book = value;
    }

    public void setBookConverter(BookConverter value) {
        this.bookConverter = value;
    }

    public BookConverter getBookConverter() {
        return bookConverter;
    }

    public void setAuthorConverter(AuthorConverter value) {
        this.authorConverter = value;
    }

    public AuthorConverter getAuthorConverter() {
        return authorConverter;
    }
}