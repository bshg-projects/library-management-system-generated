package org.bshg.librarysystem.services.event.event;

import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.repository.event.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDao dao;

    @Override
    public Event findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return dao.findAll();
    }

    public List<Event> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Event create(Event item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Event edit(Event item) {
        return dao.save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Event item) {
        if (item == null)
            return;
        dao.deleteById(item.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIdIn(List<Long> ids) {
        dao.deleteByIdIn(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Event> list) {
        if (list != null) {
            list.forEach(item -> deleteById(item.getId()));
        }
    }
}