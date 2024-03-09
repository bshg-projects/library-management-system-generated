
package org.bshg.librarysystem.sprocess.event.event.delete;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.event.event.EventService;
import org.bshg.librarysystem.sprocess.event.event.delete.DeleteEventProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteEventProcessImpl extends AbstractDeleteProcessImpl<Event, EventService> implements DeleteEventProcess {
public DeleteEventProcessImpl(EventService service) {
super(service);
}
@Override
protected void process(Event item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
}