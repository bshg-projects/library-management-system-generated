package org.bshg.librarysystem.sprocess.event.event.impl;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.facade.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.facade.UpdateEventProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateEventProcessImpl extends AbstractUpdateProcessImpl<Event, EventService> implements UpdateEventProcess {
public UpdateEventProcessImpl(EventService service) {
super(service);
}
@Override
@Transactional(rollbackFor = Exception.class)
public Event run(Event item) {
// Your Update Logic For 'Event'
item = service.edit(item);
return item;
}
}