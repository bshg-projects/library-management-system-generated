package org.bshg.librarysystem.services.facade.user;

import org.bshg.librarysystem.entity.core.user.Client;

import java.util.List;

public interface ClientService {
    Client findById(Long id);

    List<Client> findAllOptimized();

    List<Client> findAll();

    Client create(Client item);

    List<Client> create(List<Client> item);

    Client update(Client item);

    List<Client> update(List<Client> item);

    void deleteById(Long id);

    void delete(Client item);

    void delete(List<Client> items);

    void deleteByIdIn(List<Long> ids);
}