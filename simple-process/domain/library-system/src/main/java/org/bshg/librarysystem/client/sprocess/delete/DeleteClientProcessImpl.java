
package org.bshg.librarysystem.client.sprocess.delete;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.membership.sprocess.delete.DeleteMembershipProcess;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DeleteClientProcessImpl implements DeleteClientProcess {
private void process(Client item) {
// put your logic to apply before deleting the item
// like validation or something like that
}
@Transactional(rollbackFor = Exception.class)
public void run(Client item) {
process(item);
deleteAssociated(item);
service.delete(item);
}
@Transactional(rollbackFor = Exception.class)
public void run(Long id) {
Client item = service.findById(id);
if (item != null) run(item);
}
@Transactional(rollbackFor = Exception.class)
public void runByIds(List<Long> ids) {
ids.forEach(id -> {
Client item = service.findById(id);
if (item != null) {
process(item);
deleteAssociated(item);
}
});
service.deleteByIdIn(ids);
}
@Transactional(rollbackFor = Exception.class)
public void run(List<Client> items) {
items.forEach(this::process);
items.forEach(this::deleteAssociated);
service.delete(items);
}
@Transactional(rollbackFor = Exception.class)
protected void deleteAssociated(Client item) {
if (item == null || item.getId() == null) return;
deleteAssociatedList(item);
deleteAssociatedObjects(item);
}
private void deleteAssociatedList(Client item) {
deleteLoanProcess.deleteByClient(item);
deleteReservationProcess.deleteByClient(item);
deleteReviewProcess.deleteByClient(item);
deleteTransactionProcess.deleteByClient(item);
deletePaymentProcess.deleteByClient(item);
}
private void deleteAssociatedObjects(Client item) {
deleteMembershipProcess.deleteByClient(item);
}
@Autowired private ClientService service;
@Autowired @Lazy private ReservationService reservationService;
@Autowired @Lazy private PaymentService paymentService;
@Autowired @Lazy private LoanService loanService;
@Autowired @Lazy private TransactionService transactionService;
@Autowired @Lazy private ReviewService reviewService;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteReservationProcess deleteReservationProcess;
@Autowired @Lazy private DeleteReviewProcess deleteReviewProcess;
@Autowired @Lazy private DeleteTransactionProcess deleteTransactionProcess;
@Autowired @Lazy private DeletePaymentProcess deletePaymentProcess;
@Autowired @Lazy private DeleteMembershipProcess deleteMembershipProcess;
}