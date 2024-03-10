package org.bshg.librarysystem.sprocess.user.client;

import org.bshg.librarysystem.services.facade.event.PaymentService;
import org.bshg.librarysystem.services.facade.event.TransactionService;
import org.bshg.librarysystem.services.facade.library.LoanService;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.services.facade.library.ReviewService;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.UpdatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.UpdateTransactionProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.UpdateLoanProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.DeleteMembershipProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.DeleteReviewProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.UpdateReviewProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.impl.CreateClientProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.impl.DeleteClientProcessImpl;
import org.bshg.librarysystem.sprocess.user.client.impl.UpdateClientProcessImpl;
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