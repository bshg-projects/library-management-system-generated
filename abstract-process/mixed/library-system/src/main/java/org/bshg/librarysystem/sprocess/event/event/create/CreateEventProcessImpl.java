package org.bshg.librarysystem.sprocess.event.event.create;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.event.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.create.CreateEventProcess;
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