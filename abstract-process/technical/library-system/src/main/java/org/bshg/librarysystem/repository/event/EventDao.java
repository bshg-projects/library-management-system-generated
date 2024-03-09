package org.bshg.librarysystem.repository.event;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EventDao extends Repository<Event, Long> {
@Query("SELECT NEW Event(item.id,item.name) FROM Event item")
List<Event> findAllOptimized();
}