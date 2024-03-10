package org.bshg.librarysystem.event.sprocess.create;

import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.event.services.EventService;
import org.bshg.librarysystem.event.sprocess.create.CreateEventProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
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