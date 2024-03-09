package org.bshg.librarysystem.sprocess.user.client.delete;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Review;
import java.util.List;
public interface DeleteClientProcess {
void run(Client item);
void run(Long id);
void runByIds(List<Long> ids);
void run(List<Client> items);
}