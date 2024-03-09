package org.bshg.librarysystem.repository.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ClientDao extends JpaRepository<Client, Long> {
int deleteByIdIn(List<Long> ids);
}