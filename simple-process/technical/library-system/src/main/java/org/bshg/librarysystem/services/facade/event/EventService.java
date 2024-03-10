package org.bshg.librarysystem.services.facade.event;

import org.bshg.librarysystem.entity.core.event.Event;

import java.util.List;

public interface EventService {
    Event findById(Long id);

    List<Event> findAllOptimized();

    List<Event> findAll();

    Event create(Event item);

    Event edit(Event item);

    void deleteById(Long id);

    void delete(Event item);

    void delete(List<Event> items);

    void deleteByIdIn(List<Long> ids);
}