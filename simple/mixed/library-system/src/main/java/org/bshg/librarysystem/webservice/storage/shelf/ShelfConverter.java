package org.bshg.librarysystem.webservice.storage.shelf;

import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.webservice.storage.rack.RackConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShelfConverter {
    @Autowired
    private RackConverter rackConverter;
    private boolean racks = true;

    protected void convertersConfig(boolean value) {
        this.rackConverter.setShelf(value);
    }

    public final ShelfDto toDto(Shelf item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Shelf toItem(ShelfDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Shelf> toItem(List<ShelfDto> dtos) {
        if (dtos == null) return null;
        List<Shelf> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<ShelfDto> toDto(List<Shelf> items) {
        if (items == null) return null;
        List<ShelfDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Shelf convertToItem(ShelfDto dto) {
        var item = new Shelf();
        item.setId(dto.getId());
        item.setShelfNumber(dto.getShelfNumber());
        item.setRacks(rackConverter.toItem(dto.getRacks()));
        return item;
    }

    protected ShelfDto convertToDto(Shelf item) {
        var dto = new ShelfDto();
        dto.setId(item.getId());
        dto.setShelfNumber(item.getShelfNumber());
        dto.setRacks(racks ? rackConverter.toDto(item.getRacks()) : null);
        return dto;
    }

    public void setRacks(boolean value) {
        this.racks = value;
    }

    public void setRackConverter(RackConverter value) {
        this.rackConverter = value;
    }

    public RackConverter getRackConverter() {
        return rackConverter;
    }
}