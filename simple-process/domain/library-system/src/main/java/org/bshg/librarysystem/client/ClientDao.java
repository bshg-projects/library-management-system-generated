package org.bshg.librarysystem.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Long> {
    int deleteByIdIn(List<Long> ids);
}