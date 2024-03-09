
package org.bshg.librarysystem.sprocess.user.client.impl;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.DeleteMembershipProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public class DeleteClientProcessImpl extends AbstractDeleteProcessImpl<Client, ClientService> implements DeleteClientProcess {
public DeleteClientProcessImpl(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
super(service);
this.reservationService = reservationService;
this.paymentService = paymentService;
this.loanService = loanService;
this.transactionService = transactionService;
this.reviewService = reviewService;
}
@Override
protected void process(Client item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Override
public void deleteAssociatedList(Client item) {
deleteLoanProcess.deleteByClient(item);
deleteReservationProcess.deleteByClient(item);
deleteReviewProcess.deleteByClient(item);
deleteTransactionProcess.deleteByClient(item);
deletePaymentProcess.deleteByClient(item);
}
@Override
public void deleteAssociatedObjects(Client item) {
deleteMembershipProcess.deleteByClient(item);
}
private ReservationService reservationService;
private PaymentService paymentService;
private LoanService loanService;
private TransactionService transactionService;
private ReviewService reviewService;
private DeleteLoanProcess deleteLoanProcess;
public void setDeleteLoanProcess(DeleteLoanProcess value) {
this.deleteLoanProcess = value;
}
private DeleteReservationProcess deleteReservationProcess;
public void setDeleteReservationProcess(DeleteReservationProcess value) {
this.deleteReservationProcess = value;
}
private DeleteReviewProcess deleteReviewProcess;
public void setDeleteReviewProcess(DeleteReviewProcess value) {
this.deleteReviewProcess = value;
}
private DeleteTransactionProcess deleteTransactionProcess;
public void setDeleteTransactionProcess(DeleteTransactionProcess value) {
this.deleteTransactionProcess = value;
}
private DeletePaymentProcess deletePaymentProcess;
public void setDeletePaymentProcess(DeletePaymentProcess value) {
this.deletePaymentProcess = value;
}
private DeleteMembershipProcess deleteMembershipProcess;
public void setDeleteMembershipProcess(DeleteMembershipProcess value) {
this.deleteMembershipProcess = value;
}
}