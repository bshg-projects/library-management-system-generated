package org.bshg.librarysystem.client.sprocess.update;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.sprocess.update.UpdateReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.sprocess.update.UpdatePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.sprocess.update.UpdateReviewProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractUpdateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class UpdateClientProcessImpl extends AbstractUpdateProcessImpl<Client, ClientService> implements UpdateClientProcess {
public UpdateClientProcessImpl(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
super(service);
this.reservationService = reservationService;
this.paymentService = paymentService;
this.loanService = loanService;
this.transactionService = transactionService;
this.reviewService = reviewService;
}
@Override
@Transactional(rollbackFor = Exception.class)
public Client run(Client item) {
// Your Update Logic For 'Client'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
@Override
public void updateAssociatedList(Client item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
loanService::findByClientId,
Client::getLoans,
Loan::setClient,
updateLoanProcess,
deleteLoanProcess
);
ProcessHelper.updateList(
item,
reservationService::findByClientId,
Client::getReservations,
Reservation::setClient,
updateReservationProcess,
deleteReservationProcess
);
ProcessHelper.updateList(
item,
reviewService::findByClientId,
Client::getReviews,
Review::setClient,
updateReviewProcess,
deleteReviewProcess
);
ProcessHelper.updateList(
item,
transactionService::findByClientId,
Client::getTransactions,
Transaction::setClient,
updateTransactionProcess,
deleteTransactionProcess
);
ProcessHelper.updateList(
item,
paymentService::findByClientId,
Client::getPayments,
Payment::setClient,
updatePaymentProcess,
deletePaymentProcess
);
}
private ReservationService reservationService;
private UpdateReservationProcess updateReservationProcess;
private DeleteReservationProcess deleteReservationProcess;
public void setUpdateReservationProcess(UpdateReservationProcess value) {
this.updateReservationProcess = value;
}
public void setDeleteReservationProcess(DeleteReservationProcess value) {
this.deleteReservationProcess = value;
}
private PaymentService paymentService;
private UpdatePaymentProcess updatePaymentProcess;
private DeletePaymentProcess deletePaymentProcess;
public void setUpdatePaymentProcess(UpdatePaymentProcess value) {
this.updatePaymentProcess = value;
}
public void setDeletePaymentProcess(DeletePaymentProcess value) {
this.deletePaymentProcess = value;
}
private LoanService loanService;
private UpdateLoanProcess updateLoanProcess;
private DeleteLoanProcess deleteLoanProcess;
public void setUpdateLoanProcess(UpdateLoanProcess value) {
this.updateLoanProcess = value;
}
public void setDeleteLoanProcess(DeleteLoanProcess value) {
this.deleteLoanProcess = value;
}
private TransactionService transactionService;
private UpdateTransactionProcess updateTransactionProcess;
private DeleteTransactionProcess deleteTransactionProcess;
public void setUpdateTransactionProcess(UpdateTransactionProcess value) {
this.updateTransactionProcess = value;
}
public void setDeleteTransactionProcess(DeleteTransactionProcess value) {
this.deleteTransactionProcess = value;
}
private ReviewService reviewService;
private UpdateReviewProcess updateReviewProcess;
private DeleteReviewProcess deleteReviewProcess;
public void setUpdateReviewProcess(UpdateReviewProcess value) {
this.updateReviewProcess = value;
}
public void setDeleteReviewProcess(DeleteReviewProcess value) {
this.deleteReviewProcess = value;
}
}