package org.bshg.librarysystem.sprocess.user.client.delete;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Review;
public interface DeleteClientProcess extends IDeleteProcess<Client> {
}