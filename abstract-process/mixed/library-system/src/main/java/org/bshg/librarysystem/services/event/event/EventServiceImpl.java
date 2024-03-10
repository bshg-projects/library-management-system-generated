package org.bshg.librarysystem.services.event.event;

import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.repository.event.EventDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

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