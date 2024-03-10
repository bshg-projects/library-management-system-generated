package org.bshg.librarysystem.utils.webservice.converter;

import org.bshg.librarysystem.utils.entity.BaseEntity;
import org.bshg.librarysystem.utils.webservice.dto.BaseDto;

import java.util.List;

import static org.bshg.librarysystem.utils.util.ListUtil.map;

public abstract class AbstractConverter<T extends BaseEntity, DTO extends BaseDto> {
    protected Class<T> itemType;
    protected Class<DTO> dtoType;

    protected AbstractConverter() {
        this.config();
    }

    protected final void config(Class<T> itemType, Class<DTO> dtoType) {
        this.itemType = itemType;
        this.dtoType = dtoType;
        this.init(true);
    }

    protected abstract DTO convertToDto(T item);

    protected abstract T convertToItem(DTO d);

    protected abstract void config();

    protected void convertersConfig(boolean value) {
    }

    public final DTO toDto(T item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final T toItem(DTO d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<T> toItem(List<DTO> dtos) {
        return map(dtos, this::toItem);
    }

    public final List<DTO> toDto(List<T> items) {
        return map(items, this::toDto);
    }

    public void init(boolean initialisation) {
        initObject(initialisation);
        initList(initialisation);
    }

    public void initObject(boolean initialisationObject) {
    }

    public void initList(boolean initialisationList) {
    }

}
