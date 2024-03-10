package org.bshg.librarysystem.sprocess.user.client.delete;

import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.delete.DeletePaymentProcess;
import org.bshg.librarysystem.sprocess.event.transaction.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.sprocess.library.loan.delete.DeleteLoanProcess;
import org.bshg.librarysystem.sprocess.library.membership.delete.DeleteMembershipProcess;
import org.bshg.librarysystem.sprocess.library.reservation.delete.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.delete.DeleteReviewProcess;
import org.bshg.librarysystem.utils.sprocess.impl.AbstractDeleteProcessImpl;

public class DeleteClientProcessImpl extends AbstractDeleteProcessImpl<Client, ClientService> implements DeleteClientProcess {
    public DeleteClientProcessImpl(ClientService service, ReservationService reservationService, PaymentService paymentService, LoanService loanService, TransactionService transactionService, ReviewService reviewService) {
        super(service);
        this.reservationService = reservationService;
        this.paymentService = paymentService;
        this.loanService = loanService;
        this.transactionService = transactionService;
        this.reviewService = reviewService;
    }

    @Override
    protected void process(Client item) {
// put your logic to apply before deleting the item
// like validation or something like that
    }

    @Override
    public void deleteAssociatedList(Client item) {
        deleteLoanProcess.deleteByClient(item);
        deleteReservationProcess.deleteByClient(item);
        deleteReviewProcess.deleteByClient(item);
        deleteTransactionProcess.deleteByClient(item);
        deletePaymentProcess.deleteByClient(item);
    }

    @Override
    public void deleteAssociatedObjects(Client item) {
        deleteMembershipProcess.deleteByClient(item);
    }

    private ReservationService reservationService;
    private PaymentService paymentService;
    private LoanService loanService;
    private TransactionService transactionService;
    private ReviewService reviewService;
    private DeleteLoanProcess deleteLoanProcess;

    public void setDeleteLoanProcess(DeleteLoanProcess value) {
        this.deleteLoanProcess = value;
    }

    private DeleteReservationProcess deleteReservationProcess;

    public void setDeleteReservationProcess(DeleteReservationProcess value) {
        this.deleteReservationProcess = value;
    }

    private DeleteReviewProcess deleteReviewProcess;

    public void setDeleteReviewProcess(DeleteReviewProcess value) {
        this.deleteReviewProcess = value;
    }

    private DeleteTransactionProcess deleteTransactionProcess;

    public void setDeleteTransactionProcess(DeleteTransactionProcess value) {
        this.deleteTransactionProcess = value;
    }

    private DeletePaymentProcess deletePaymentProcess;

    public void setDeletePaymentProcess(DeletePaymentProcess value) {
        this.deletePaymentProcess = value;
    }

    private DeleteMembershipProcess deleteMembershipProcess;

    public void setDeleteMembershipProcess(DeleteMembershipProcess value) {
        this.deleteMembershipProcess = value;
    }
}