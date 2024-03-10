package org.bshg.librarysystem.client.sprocess.delete;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.membership.sprocess.delete.DeleteMembershipProcess;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
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