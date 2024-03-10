package org.bshg.librarysystem.sprocess.event.event.update;

import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.event.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateEventProcessImpl implements UpdateEventProcess {
    @Transactional(rollbackFor = Exception.class)
    public Event run(Event item) { // Your Logic To Update 'Event'
        item = service.edit(item);
        return item;
    }

    public List<Event> run(List<Event> items) {
        items.forEach(this::run);
        return items;
    }

    @Autowired
    private EventService service;
}