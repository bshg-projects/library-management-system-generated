package org.bshg.librarysystem.webservice.dto.storage;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;
import org.bshg.librarysystem.webservice.dto.content.BookDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RackDto extends AuditBaseDto {
    public RackDto() {
        super();
    }

    private String rackNumber;
    private List<BookDto> books;
    private ShelfDto shelf;

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String value) {
        this.rackNumber = value;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> value) {
        this.books = value;
    }

    public ShelfDto getShelf() {
        return shelf;
    }

    public void setShelf(ShelfDto value) {
        this.shelf = value;
    }
}