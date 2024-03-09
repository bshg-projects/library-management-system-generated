package org.bshg.librarysystem.sprocess.user.client.create;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcess;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.create.CreateReviewProcess;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractCreateProcessImpl;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.transaction.annotation.Transactional;
public class CreateClientProcessImpl extends AbstractCreateProcessImpl<Client, ClientService> implements CreateClientProcess {
public CreateClientProcessImpl(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
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
// Your Insert Logic For 'Client'
item = service.create(item);
createAssociatedList(item);
return item;
}
@Override
public void createAssociatedList(Client item) {
if (item == null || item.getId() == null) return;
ProcessHelper.createList(item, Client::getLoans, Loan::setClient, createLoanProcess);
ProcessHelper.createList(item, Client::getReservations, Reservation::setClient, createReservationProcess);
ProcessHelper.createList(item, Client::getReviews, Review::setClient, createReviewProcess);
ProcessHelper.createList(item, Client::getTransactions, Transaction::setClient, createTransactionProcess);
ProcessHelper.createList(item, Client::getPayments, Payment::setClient, createPaymentProcess);
}
private ReservationService reservationService;
private CreateReservationProcess createReservationProcess;
public void setCreateReservationProcess(CreateReservationProcess value) {
this.createReservationProcess = value;
}
private PaymentService paymentService;
private CreatePaymentProcess createPaymentProcess;
public void setCreatePaymentProcess(CreatePaymentProcess value) {
this.createPaymentProcess = value;
}
private LoanService loanService;
private CreateLoanProcess createLoanProcess;
public void setCreateLoanProcess(CreateLoanProcess value) {
this.createLoanProcess = value;
}
private TransactionService transactionService;
private CreateTransactionProcess createTransactionProcess;
public void setCreateTransactionProcess(CreateTransactionProcess value) {
this.createTransactionProcess = value;
}
private ReviewService reviewService;
private CreateReviewProcess createReviewProcess;
public void setCreateReviewProcess(CreateReviewProcess value) {
this.createReviewProcess = value;
}
}