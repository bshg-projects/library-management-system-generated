
package org.bshg.librarysystem.sprocess.user.client.delete;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.library.membership.delete.DeleteMembershipProcess;
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