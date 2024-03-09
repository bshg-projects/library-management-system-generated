package org.bshg.librarysystem.client.sprocess.create;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcess;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcess;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcess;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
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