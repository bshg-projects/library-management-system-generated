package org.bshg.librarysystem.webservice.converter.storage;

import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.bshg.librarysystem.webservice.dto.storage.ShelfDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShelfConverter extends AbstractConverter<Shelf, ShelfDto> {
    @Autowired
    private RackConverter rackConverter;
    private boolean racks = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.rackConverter.setShelf(value);
    }

    @Override
    protected Shelf convertToItem(ShelfDto dto) {
        var item = new Shelf();
        item.setId(dto.getId());
        item.setShelfNumber(dto.getShelfNumber());
        item.setRacks(rackConverter.toItem(dto.getRacks()));
        return item;
    }

    @Override
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