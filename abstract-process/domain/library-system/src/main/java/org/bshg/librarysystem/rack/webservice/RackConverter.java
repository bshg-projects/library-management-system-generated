package org.bshg.librarysystem.rack.webservice;

import org.bshg.librarysystem.book.webservice.BookConverter;
import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.shelf.webservice.ShelfConverter;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RackConverter extends AbstractConverter<Rack, RackDto> {
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private ShelfConverter shelfConverter;
    private boolean books = true;
    private boolean shelf = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.bookConverter.setRack(value);
        this.shelfConverter.setRacks(value);
    }

    @Override
    protected Rack convertToItem(RackDto dto) {
        var item = new Rack();
        item.setId(dto.getId());
        item.setRackNumber(dto.getRackNumber());
        item.setBooks(bookConverter.toItem(dto.getBooks()));
        item.setShelf(shelfConverter.toItem(dto.getShelf()));
        return item;
    }

    @Override
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