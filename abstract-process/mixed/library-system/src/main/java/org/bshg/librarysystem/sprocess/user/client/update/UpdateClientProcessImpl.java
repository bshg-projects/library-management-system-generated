package org.bshg.librarysystem.sprocess.user.client.update;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.sprocess.library.reservation.update.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.sprocess.event.payment.update.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.sprocess.library.review.update.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
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