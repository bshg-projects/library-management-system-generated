package org.bshg.librarysystem.client;
import org.bshg.librarysystem.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ClientDao extends JpaRepository<Client, Long> {
int deleteByIdIn(List<Long> ids);
}