package org.bshg.librarysystem.rack;
import org.bshg.librarysystem.rack.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface RackDao extends JpaRepository<Rack, Long> {
int deleteByIdIn(List<Long> ids);
int deleteByShelfId(Long id);
List<Rack> findByShelfId(Long id);
}