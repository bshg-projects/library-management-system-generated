
package org.bshg.librarysystem.sprocess.event.event.delete;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.event.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.delete.DeleteEventProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteEventProcessImpl implements DeleteEventProcess {
private void process(Event item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Event item) {
process(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Event item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Event item = service.findById(id);
if (item != null) {
process(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Event> items) {
items.forEach(this::process);
service.delete(items);
}
@Autowired private EventService service;
}