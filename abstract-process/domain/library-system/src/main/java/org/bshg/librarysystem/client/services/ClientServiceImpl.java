package org.bshg.librarysystem.client.services;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.ClientDao;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ClientServiceImpl extends ServiceImpl<Client, ClientDao> implements ClientService {
public ClientServiceImpl(ClientDao dao) {
super(dao);
}
}