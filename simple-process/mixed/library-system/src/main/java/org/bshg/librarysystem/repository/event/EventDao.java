package org.bshg.librarysystem.repository.event;
import org.bshg.librarysystem.entity.core.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface EventDao extends JpaRepository<Event, Long> {
int deleteByIdIn(List<Long> ids);
@Query("SELECT NEW Event(item.id,item.name) FROM Event item")
List<Event> findAllOptimized();
}