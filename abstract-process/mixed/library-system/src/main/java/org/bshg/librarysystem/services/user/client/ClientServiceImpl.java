package org.bshg.librarysystem.services.user.client;

import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.repository.user.ClientDao;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<Client, ClientDao> implements ClientService {
    public ClientServiceImpl(ClientDao dao) {
        super(dao);
    }
}