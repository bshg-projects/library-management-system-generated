package org.bshg.librarysystem.event.sprocess.create;
import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.event.services.EventService;
import org.bshg.librarysystem.event.sprocess.create.CreateEventProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class CreateEventProcessImpl implements CreateEventProcess {
@Transactional(rollbackFor = Exception.class)
public Event run(Event item) {
// Your Creation Logic For 'Event'
item = service.create(item);
return item;
}
public List<Event> run(List<Event> items) {
items.forEach(this::run);
return items;
}
@Autowired private EventService service;
}