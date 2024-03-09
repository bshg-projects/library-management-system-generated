package org.bshg.librarysystem.client.sprocess.delete;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
public interface DeleteClientProcess extends IDeleteProcess<Client> {
}