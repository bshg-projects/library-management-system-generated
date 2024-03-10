package org.bshg.librarysystem.sprocess.event.event.impl;

import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.facade.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.facade.CreateEventProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.springframework.transaction.annotation.Transactional;

public class CreateEventProcessImpl extends AbstractCreateProcessImpl<Event, EventService> implements CreateEventProcess {
    public CreateEventProcessImpl(EventService service) {
        super(service);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Event run(Event item) {
// Your Insert Logic For 'Event'
        item = service.create(item);
        return item;
    }
}