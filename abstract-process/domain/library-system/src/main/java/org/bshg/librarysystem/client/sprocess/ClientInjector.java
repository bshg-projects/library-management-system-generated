package org.bshg.librarysystem.client.sprocess;

import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcess;
import org.bshg.librarysystem.client.sprocess.create.CreateClientProcessImpl;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcess;
import org.bshg.librarysystem.client.sprocess.delete.DeleteClientProcessImpl;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcess;
import org.bshg.librarysystem.client.sprocess.update.UpdateClientProcessImpl;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.membership.sprocess.delete.DeleteMembershipProcess;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.update.UpdatePaymentProcess;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.update.UpdateReservationProcess;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcess;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.review.sprocess.update.UpdateReviewProcess;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Inject Client Processes (Create, Update, Delete).
 */
@Configuration
public class ClientInjector {
    @Bean
    public CreateClientProcess createClientProcess(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
        var bean = new CreateClientProcessImpl(service, reservationService, paymentService, loanService, transactionService, reviewService);
        bean.setCreateReservationProcess(this.createReservationProcess);
        bean.setCreatePaymentProcess(this.createPaymentProcess);
        bean.setCreateLoanProcess(this.createLoanProcess);
        bean.setCreateTransactionProcess(this.createTransactionProcess);
        bean.setCreateReviewProcess(this.createReviewProcess);
        return bean;
    }

    @Bean
    public UpdateClientProcess updateClientProcess(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
        var bean = new UpdateClientProcessImpl(service, reservationService, paymentService, loanService, transactionService, reviewService);
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
    public DeleteClientProcess deleteClientProcess(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
        var bean = new DeleteClientProcessImpl(service, reservationService, paymentService, loanService, transactionService, reviewService);
        bean.setDeleteLoanProcess(this.deleteLoanProcess);
        bean.setDeleteReservationProcess(this.deleteReservationProcess);
        bean.setDeleteReviewProcess(this.deleteReviewProcess);
        bean.setDeleteTransactionProcess(this.deleteTransactionProcess);
        bean.setDeletePaymentProcess(this.deletePaymentProcess);
        bean.setDeleteMembershipProcess(this.deleteMembershipProcess);
        return bean;
    }

    @Autowired
    @Lazy
    private CreateReservationProcess createReservationProcess;
    @Autowired
    @Lazy
    private UpdateReservationProcess updateReservationProcess;
    @Autowired
    @Lazy
    private CreatePaymentProcess createPaymentProcess;
    @Autowired
    @Lazy
    private UpdatePaymentProcess updatePaymentProcess;
    @Autowired
    @Lazy
    private CreateLoanProcess createLoanProcess;
    @Autowired
    @Lazy
    private UpdateLoanProcess updateLoanProcess;
    @Autowired
    @Lazy
    private CreateTransactionProcess createTransactionProcess;
    @Autowired
    @Lazy
    private UpdateTransactionProcess updateTransactionProcess;
    @Autowired
    @Lazy
    private CreateReviewProcess createReviewProcess;
    @Autowired
    @Lazy
    private UpdateReviewProcess updateReviewProcess;
    @Autowired
    @Lazy
    private DeleteLoanProcess deleteLoanProcess;
    @Autowired
    @Lazy
    private DeleteReservationProcess deleteReservationProcess;
    @Autowired
    @Lazy
    private DeleteReviewProcess deleteReviewProcess;
    @Autowired
    @Lazy
    private DeleteTransactionProcess deleteTransactionProcess;
    @Autowired
    @Lazy
    private DeletePaymentProcess deletePaymentProcess;
    @Autowired
    @Lazy
    private DeleteMembershipProcess deleteMembershipProcess;
}