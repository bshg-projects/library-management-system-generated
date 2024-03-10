package org.bshg.librarysystem.webservice.event.event;

import org.bshg.librarysystem.entity.core.event.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventConverter {
    protected void convertersConfig(boolean value) {
    }

    public final EventDto toDto(Event item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Event toItem(EventDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Event> toItem(List<EventDto> dtos) {
        if (dtos == null) return null;
        List<Event> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<EventDto> toDto(List<Event> items) {
        if (items == null) return null;
        List<EventDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Event convertToItem(EventDto dto) {
        var item = new Event();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setStartDate(dto.getStartDate());
        item.setEndDate(dto.getEndDate());
        item.setLocation(dto.getLocation());
        return item;
    }

    protected EventDto convertToDto(Event item) {
        var dto = new EventDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setStartDate(item.getStartDate());
        dto.setEndDate(item.getEndDate());
        dto.setLocation(item.getLocation());
        return dto;
    }
}