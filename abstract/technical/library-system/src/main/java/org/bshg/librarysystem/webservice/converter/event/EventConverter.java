package org.bshg.librarysystem.webservice.converter.event;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.webservice.dto.event.EventDto;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class EventConverter extends AbstractConverter<Event, EventDto> {
@Override
protected void config() {
config(Event.class, EventDto.class);
}
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