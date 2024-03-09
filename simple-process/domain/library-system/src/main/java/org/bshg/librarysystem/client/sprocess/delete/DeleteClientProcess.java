package org.bshg.librarysystem.client.sprocess.delete;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
import java.util.List;
public interface DeleteClientProcess {
void run(Client item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Client> items);
}