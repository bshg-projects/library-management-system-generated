package org.bshg.librarysystem.event.services;
import org.bshg.librarysystem.event.Event;
import org.bshg.librarysystem.event.EventDao;
import org.bshg.librarysystem.event.services.EventService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EventServiceImpl extends ServiceImpl<Event, EventDao> implements EventService {
public EventServiceImpl(EventDao dao) {
super(dao);
}
@Override
public List<Event> findAllOptimized() {
return dao.findAllOptimized();
}
}