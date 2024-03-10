package org.bshg.librarysystem.rack.webservice;

import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.shelf.webservice.ShelfConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RackConverter {
    public void init(boolean initialisation) {
        this.books = initialisation;
        this.shelf = initialisation;
    }

    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private ShelfConverter shelfConverter;
    private boolean books = true;
    private boolean shelf = true;

    protected void convertersConfig(boolean value) {
        this.bookConverter.setRack(value);
        this.shelfConverter.setRacks(value);
    }

    public final RackDto toDto(Rack item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Rack toItem(RackDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Rack> toItem(List<RackDto> dtos) {
        if (dtos == null) return null;
        List<Rack> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<RackDto> toDto(List<Rack> items) {
        if (items == null) return null;
        List<RackDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Rack convertToItem(RackDto dto) {
        var item = new Rack();
        item.setId(dto.getId());
        item.setRackNumber(dto.getRackNumber());
        item.setBooks(bookConverter.toItem(dto.getBooks()));
        item.setShelf(shelfConverter.toItem(dto.getShelf()));
        return item;
    }

    protected RackDto convertToDto(Rack item) {
        var dto = new RackDto();
        dto.setId(item.getId());
        dto.setRackNumber(item.getRackNumber());
        dto.setBooks(books ? bookConverter.toDto(item.getBooks()) : null);
        dto.setShelf(shelf ? shelfConverter.toDto(item.getShelf()) : null);
        return dto;
    }

    public void setBooks(boolean value) {
        this.books = value;
    }

    public void setShelf(boolean value) {
        this.shelf = value;
    }

    public void setBookConverter(BookConverter value) {
        this.bookConverter = value;
    }

    public BookConverter getBookConverter() {
        return bookConverter;
    }

    public void setShelfConverter(ShelfConverter value) {
        this.shelfConverter = value;
    }

    public ShelfConverter getShelfConverter() {
        return shelfConverter;
    }
}