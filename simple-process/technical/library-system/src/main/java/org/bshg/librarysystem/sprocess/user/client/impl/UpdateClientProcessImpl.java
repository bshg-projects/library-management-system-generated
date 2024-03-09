package org.bshg.librarysystem.sprocess.user.client.impl;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.sprocess.library.loan.facade.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.sprocess.event.transaction.facade.UpdateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.DeleteTransactionProcess;
import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.sprocess.event.payment.facade.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class UpdateClientProcessImpl implements UpdateClientProcess {
@Transactional(rollbackFor = Exception.class)
public Client run(Client item) { // Your Logic To Update 'Client'
item = service.edit(item);
updateAssociatedList(item);
return item;
}
public List<Client> run(List<Client> items) {
items.forEach(this::run);
return items;
}
public void updateAssociatedList(Client item) {
if (item == null || item.getId() == null) return;
ProcessHelper.updateList(
item,
loanService.findByClientId(item.getId()),
item.getLoans(),
Loan::setClient,
updateLoanProcess::run,
deleteLoanProcess::run
);
ProcessHelper.updateList(
item,
reservationService.findByClientId(item.getId()),
item.getReservations(),
Reservation::setClient,
updateReservationProcess::run,
deleteReservationProcess::run
);
ProcessHelper.updateList(
item,
reviewService.findByClientId(item.getId()),
item.getReviews(),
Review::setClient,
updateReviewProcess::run,
deleteReviewProcess::run
);
ProcessHelper.updateList(
item,
transactionService.findByClientId(item.getId()),
item.getTransactions(),
Transaction::setClient,
updateTransactionProcess::run,
deleteTransactionProcess::run
);
ProcessHelper.updateList(
item,
paymentService.findByClientId(item.getId()),
item.getPayments(),
Payment::setClient,
updatePaymentProcess::run,
deletePaymentProcess::run
);
}
@Autowired private ClientService service;
@Autowired LoanService loanService;
@Autowired @Lazy private UpdateLoanProcess updateLoanProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired ReservationService reservationService;
@Autowired @Lazy private UpdateReservationProcess updateReservationProcess;
@Autowired @Lazy private DeleteReservationProcess deleteReservationProcess;
@Autowired ReviewService reviewService;
@Autowired @Lazy private UpdateReviewProcess updateReviewProcess;
@Autowired @Lazy private DeleteReviewProcess deleteReviewProcess;
@Autowired TransactionService transactionService;
@Autowired @Lazy private UpdateTransactionProcess updateTransactionProcess;
@Autowired @Lazy private DeleteTransactionProcess deleteTransactionProcess;
@Autowired PaymentService paymentService;
@Autowired @Lazy private UpdatePaymentProcess updatePaymentProcess;
@Autowired @Lazy private DeletePaymentProcess deletePaymentProcess;
}