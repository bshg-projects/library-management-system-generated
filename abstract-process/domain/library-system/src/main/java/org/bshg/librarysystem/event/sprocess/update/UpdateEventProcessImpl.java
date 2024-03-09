package org.bshg.librarysystem.event.sprocess.update;
import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.event.services.EventService;
import org.bshg.librarysystem.event.sprocess.update.UpdateEventProcess;
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