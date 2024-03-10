package org.bshg.librarysystem.webservice.content.publisher;

import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.webservice.content.book.BookConverter;
import org.bshg.librarysystem.webservice.content.magazine.MagazineConverter;
import org.bshg.librarysystem.webservice.library.address.AddressConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherConverter {
    public void init(boolean initialisation) {
        this.books = initialisation;
        this.magazines = initialisation;
        this.address = initialisation;
    }

    @Autowired
    private AddressConverter addressConverter;
    @Autowired
    private BookConverter bookConverter;
    @Autowired
    private MagazineConverter magazineConverter;
    private boolean books = true;
    private boolean magazines = true;
    private boolean address = true;

    protected void convertersConfig(boolean value) {
        this.bookConverter.setPublisher(value);
        this.magazineConverter.setPublisher(value);
    }

    public final PublisherDto toDto(Publisher item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Publisher toItem(PublisherDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Publisher> toItem(List<PublisherDto> dtos) {
        if (dtos == null) return null;
        List<Publisher> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<PublisherDto> toDto(List<Publisher> items) {
        if (items == null) return null;
        List<PublisherDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Publisher convertToItem(PublisherDto dto) {
        var item = new Publisher();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setBooks(bookConverter.toItem(dto.getBooks()));
        item.setMagazines(magazineConverter.toItem(dto.getMagazines()));
        item.setAddress(addressConverter.toItem(dto.getAddress()));
        return item;
    }

    protected PublisherDto convertToDto(Publisher item) {
        var dto = new PublisherDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setBooks(books ? bookConverter.toDto(item.getBooks()) : null);
        dto.setMagazines(magazines ? magazineConverter.toDto(item.getMagazines()) : null);
        dto.setAddress(address ? addressConverter.toDto(item.getAddress()) : null);
        return dto;
    }

    public void setBooks(boolean value) {
        this.books = value;
    }

    public void setMagazines(boolean value) {
        this.magazines = value;
    }

    public void setAddress(boolean value) {
        this.address = value;
    }

    public void setAddressConverter(AddressConverter value) {
        this.addressConverter = value;
    }

    public AddressConverter getAddressConverter() {
        return addressConverter;
    }

    public void setBookConverter(BookConverter value) {
        this.bookConverter = value;
    }

    public BookConverter getBookConverter() {
        return bookConverter;
    }

    public void setMagazineConverter(MagazineConverter value) {
        this.magazineConverter = value;
    }

    public MagazineConverter getMagazineConverter() {
        return magazineConverter;
    }
}