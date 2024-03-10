package org.bshg.librarysystem.event.webservice;

import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class EventConverter extends AbstractConverter<Event, EventDto> {
    @Override
    protected Event convertToItem(EventDto dto) {
        var item = new Event();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setStartDate(dto.getStartDate());
        item.setEndDate(dto.getEndDate());
        item.setLocation(dto.getLocation());
        return item;
    }

    @Override
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