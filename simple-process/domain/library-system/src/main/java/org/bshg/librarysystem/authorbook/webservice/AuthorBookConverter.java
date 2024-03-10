package org.bshg.librarysystem.authorbook.webservice;

import org.bshg.librarysystem.author.webservice.AuthorConverter;
import org.bshg.librarysystem.authorbook.AuthorBook;
import org.bshg.librarysystem.book.webservice.BookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorBookConverter {
    public void init(boolean initialisation) {
        this.author = initialisation;
        this.book = initialisation;
    }

    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private AuthorConverter authorConverter;
    private boolean author = true;
    private boolean book = true;

    protected void convertersConfig(boolean value) {
        this.bookConverter.setAuthorBook(value);
        this.authorConverter.setAuthorBook(value);
    }

    public final AuthorBookDto toDto(AuthorBook item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final AuthorBook toItem(AuthorBookDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<AuthorBook> toItem(List<AuthorBookDto> dtos) {
        if (dtos == null) return null;
        List<AuthorBook> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<AuthorBookDto> toDto(List<AuthorBook> items) {
        if (items == null) return null;
        List<AuthorBookDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected AuthorBook convertToItem(AuthorBookDto dto) {
        var item = new AuthorBook();
        item.setId(dto.getId());
        item.setContribution(dto.getContribution());
        item.setRole(dto.getRole());
        item.setAuthor(authorConverter.toItem(dto.getAuthor()));
        item.setBook(bookConverter.toItem(dto.getBook()));
        return item;
    }

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