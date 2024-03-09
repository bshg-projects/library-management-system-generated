package org.bshg.librarysystem.services.facade.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Review;
import java.util.List;
public interface ClientService {
Client findById(Long id);
List<Client> findAllOptimized();
List<Client> findAll();
Client create(Client item);
Client edit(Client item);
void deleteById(Long id);
void delete(Client item);
void delete(List<Client> items);
void deleteByIdIn(List<Long> ids);
}