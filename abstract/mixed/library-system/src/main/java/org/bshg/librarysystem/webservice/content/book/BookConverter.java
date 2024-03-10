package org.bshg.librarysystem.webservice.content.book;

import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.content.authorbook.AuthorBookConverter;
import org.bshg.librarysystem.webservice.content.bookgenre.BookGenreConverter;
import org.bshg.librarysystem.webservice.content.publisher.PublisherConverter;
import org.bshg.librarysystem.webservice.storage.rack.RackConverter;
import org.bshg.librarysystem.webservice.user.admin.employee.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter extends AbstractConverter<Book, BookDto> {
    @Autowired
    private RackConverter rackConverter;
    @Autowired
    private BookGenreConverter bookGenreConverter;
    @Autowired
    private EmployeeConverter employeeConverter;
    @Autowired
    private AuthorBookConverter authorBookConverter;
    @Autowired
    private PublisherConverter publisherConverter;
    private boolean authorBook = true;
    private boolean bookGenre = true;
    private boolean employee = true;
    private boolean publisher = true;
    private boolean rack = true;

    @Override
    protected void config() {
        config(Book.class, BookDto.class);
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.rackConverter.setBooks(value);
        this.bookGenreConverter.setBook(value);
        this.employeeConverter.setBooks(value);
        this.authorBookConverter.setBook(value);
        this.publisherConverter.setBooks(value);
    }

    @Override
    protected Book convertToItem(BookDto dto) {
        var item = new Book();
        item.setId(dto.getId());
        item.setTitle(dto.getTitle());
        item.setPublicationDate(dto.getPublicationDate());
        item.setIsbn(dto.getIsbn());
        item.setPageCount(dto.getPageCount());
        item.setDescription(dto.getDescription());
        item.setAuthorBook(authorBookConverter.toItem(dto.getAuthorBook()));
        item.setBookGenre(bookGenreConverter.toItem(dto.getBookGenre()));
        item.setEmployee(employeeConverter.toItem(dto.getEmployee()));
        item.setPublisher(publisherConverter.toItem(dto.getPublisher()));
        item.setRack(rackConverter.toItem(dto.getRack()));
        return item;
    }

    @Override
    protected BookDto convertToDto(Book item) {
        var dto = new BookDto();
        dto.setId(item.getId());
        dto.setTitle(item.getTitle());
        dto.setPublicationDate(item.getPublicationDate());
        dto.setIsbn(item.getIsbn());
        dto.setPageCount(item.getPageCount());
        dto.setDescription(item.getDescription());
        dto.setAuthorBook(authorBook ? authorBookConverter.toDto(item.getAuthorBook()) : null);
        dto.setBookGenre(bookGenre ? bookGenreConverter.toDto(item.getBookGenre()) : null);
        dto.setEmployee(employee ? employeeConverter.toDto(item.getEmployee()) : null);
        dto.setPublisher(publisher ? publisherConverter.toDto(item.getPublisher()) : null);
        dto.setRack(rack ? rackConverter.toDto(item.getRack()) : null);
        return dto;
    }

    public void setAuthorBook(boolean value) {
        this.authorBook = value;
    }

    public void setBookGenre(boolean value) {
        this.bookGenre = value;
    }

    public void setEmployee(boolean value) {
        this.employee = value;
    }

    public void setPublisher(boolean value) {
        this.publisher = value;
    }

    public void setRack(boolean value) {
        this.rack = value;
    }

    public void setRackConverter(RackConverter value) {
        this.rackConverter = value;
    }

    public RackConverter getRackConverter() {
        return rackConverter;
    }

    public void setBookGenreConverter(BookGenreConverter value) {
        this.bookGenreConverter = value;
    }

    public BookGenreConverter getBookGenreConverter() {
        return bookGenreConverter;
    }

    public void setEmployeeConverter(EmployeeConverter value) {
        this.employeeConverter = value;
    }

    public EmployeeConverter getEmployeeConverter() {
        return employeeConverter;
    }

    public void setAuthorBookConverter(AuthorBookConverter value) {
        this.authorBookConverter = value;
    }

    public AuthorBookConverter getAuthorBookConverter() {
        return authorBookConverter;
    }

    public void setPublisherConverter(PublisherConverter value) {
        this.publisherConverter = value;
    }

    public PublisherConverter getPublisherConverter() {
        return publisherConverter;
    }
}