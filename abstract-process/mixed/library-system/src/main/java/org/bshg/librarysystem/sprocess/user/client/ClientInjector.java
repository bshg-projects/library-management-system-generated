package org.bshg.librarysystem.sprocess.user.client;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.create.CreateClientProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.update.UpdateClientProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.delete.DeleteClientProcessImpl;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.update.UpdateReservationProcess;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.update.UpdatePaymentProcess;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.update.UpdateLoanProcess;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.update.UpdateTransactionProcess;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.sprocess.library.review.create.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.update.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.library.membership.delete.DeleteMembershipProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Client Processes (Create, Update, Delete).
*/
@Configuration
public class ClientInjector {
@Bean
public CreateClientProcess createClientProcess (ClientService service,ReservationService reservationService,PaymentService paymentService,LoanService loanService,TransactionService transactionService,ReviewService reviewService) {
var bean = new CreateClientProcessImpl(service, reservationService, paymentService, loanService, transactionService, reviewService);
bean.setCreateReservationProcess(this.createReservationProcess);
bean.setCreatePaymentProcess(this.createPaymentProcess);
bean.setCreateLoanProcess(this.createLoanProcess);
bean.setCreateTransactionProcess(this.createTransactionProcess);
bean.setCreateReviewProcess(this.createReviewProcess);
return bean;
}
@Bean
public UpdateClientProcess updateClientProcess (ClientService service,ReservationService reservationService,PaymentService paymentService,LoanService loanService,TransactionService transactionService,ReviewService reviewService) {
var bean = new UpdateClientProcessImpl(service,reservationService,paymentService,loanService,transactionService,reviewService);
bean.setUpdateReservationProcess(this.updateReservationProcess);
bean.setDeleteReservationProcess(this.deleteReservationProcess);
bean.setUpdatePaymentProcess(this.updatePaymentProcess);
bean.setDeletePaymentProcess(this.deletePaymentProcess);
bean.setUpdateLoanProcess(this.updateLoanProcess);
bean.setDeleteLoanProcess(this.deleteLoanProcess);
bean.setUpdateTransactionProcess(this.updateTransactionProcess);
bean.setDeleteTransactionProcess(this.deleteTransactionProcess);
bean.setUpdateReviewProcess(this.updateReviewProcess);
bean.setDeleteReviewProcess(this.deleteReviewProcess);
return bean;
}
@Bean
public DeleteClientProcess deleteClientProcess(ClientService service,ReservationService reservationService,PaymentService paymentService,LoanService loanService,TransactionService transactionService,ReviewService reviewService) {
var bean = new DeleteClientProcessImpl(service,reservationService,paymentService,loanService,transactionService,reviewService);
bean.setDeleteLoanProcess(this.deleteLoanProcess);
bean.setDeleteReservationProcess(this.deleteReservationProcess);
bean.setDeleteReviewProcess(this.deleteReviewProcess);
bean.setDeleteTransactionProcess(this.deleteTransactionProcess);
bean.setDeletePaymentProcess(this.deletePaymentProcess);
bean.setDeleteMembershipProcess(this.deleteMembershipProcess);
return bean;
}
@Autowired @Lazy private CreateReservationProcess createReservationProcess;
@Autowired @Lazy private UpdateReservationProcess updateReservationProcess;
@Autowired @Lazy private CreatePaymentProcess createPaymentProcess;
@Autowired @Lazy private UpdatePaymentProcess updatePaymentProcess;
@Autowired @Lazy private CreateLoanProcess createLoanProcess;
@Autowired @Lazy private UpdateLoanProcess updateLoanProcess;
@Autowired @Lazy private CreateTransactionProcess createTransactionProcess;
@Autowired @Lazy private UpdateTransactionProcess updateTransactionProcess;
@Autowired @Lazy private CreateReviewProcess createReviewProcess;
@Autowired @Lazy private UpdateReviewProcess updateReviewProcess;
@Autowired @Lazy private DeleteLoanProcess deleteLoanProcess;
@Autowired @Lazy private DeleteReservationProcess deleteReservationProcess;
@Autowired @Lazy private DeleteReviewProcess deleteReviewProcess;
@Autowired @Lazy private DeleteTransactionProcess deleteTransactionProcess;
@Autowired @Lazy private DeletePaymentProcess deletePaymentProcess;
@Autowired @Lazy private DeleteMembershipProcess deleteMembershipProcess;
}