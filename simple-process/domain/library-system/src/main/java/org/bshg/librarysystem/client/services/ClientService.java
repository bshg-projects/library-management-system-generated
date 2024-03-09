package org.bshg.librarysystem.client.services;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
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