package org.bshg.librarysystem.book.webservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.authorbook.webservice.AuthorBookDto;
import org.bshg.librarysystem.bookgenre.webservice.BookGenreDto;
import org.bshg.librarysystem.employee.webservice.EmployeeDto;
import org.bshg.librarysystem.publisher.webservice.PublisherDto;
import org.bshg.librarysystem.rack.webservice.RackDto;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto extends AuditBaseDto {
    public BookDto() {
        super();
    }

    private String title;
    private LocalDate publicationDate;
    private String isbn;
    private int pageCount;
    private String description;
    private List<AuthorBookDto> authorBook;
    private List<BookGenreDto> bookGenre;
    private EmployeeDto employee;
    private PublisherDto publisher;
    private RackDto rack;

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate value) {
        this.publicationDate = value;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String value) {
        this.isbn = value;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int value) {
        this.pageCount = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public List<AuthorBookDto> getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(List<AuthorBookDto> value) {
        this.authorBook = value;
    }

    public List<BookGenreDto> getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(List<BookGenreDto> value) {
        this.bookGenre = value;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto value) {
        this.employee = value;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto value) {
        this.publisher = value;
    }

    public RackDto getRack() {
        return rack;
    }

    public void setRack(RackDto value) {
        this.rack = value;
    }
}