package org.bshg.librarysystem.services.user.client;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.repository.user.ClientDao;
import org.bshg.librarysystem.services.user.client.ClientService;
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