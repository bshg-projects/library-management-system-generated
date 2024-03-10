package org.bshg.librarysystem.client.sprocess.update;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.delete.DeleteLoanProcess;
import org.bshg.librarysystem.loan.sprocess.update.UpdateLoanProcess;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.delete.DeletePaymentProcess;
import org.bshg.librarysystem.payment.sprocess.update.UpdatePaymentProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.delete.DeleteReservationProcess;
import org.bshg.librarysystem.reservation.sprocess.update.UpdateReservationProcess;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.delete.DeleteReviewProcess;
import org.bshg.librarysystem.review.sprocess.update.UpdateReviewProcess;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.delete.DeleteTransactionProcess;
import org.bshg.librarysystem.transaction.sprocess.update.UpdateTransactionProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ClientService service;
    @Autowired
    LoanService loanService;
    @Autowired
    @Lazy
    private UpdateLoanProcess updateLoanProcess;
    @Autowired
    @Lazy
    private DeleteLoanProcess deleteLoanProcess;
    @Autowired
    ReservationService reservationService;
    @Autowired
    @Lazy
    private UpdateReservationProcess updateReservationProcess;
    @Autowired
    @Lazy
    private DeleteReservationProcess deleteReservationProcess;
    @Autowired
    ReviewService reviewService;
    @Autowired
    @Lazy
    private UpdateReviewProcess updateReviewProcess;
    @Autowired
    @Lazy
    private DeleteReviewProcess deleteReviewProcess;
    @Autowired
    TransactionService transactionService;
    @Autowired
    @Lazy
    private UpdateTransactionProcess updateTransactionProcess;
    @Autowired
    @Lazy
    private DeleteTransactionProcess deleteTransactionProcess;
    @Autowired
    PaymentService paymentService;
    @Autowired
    @Lazy
    private UpdatePaymentProcess updatePaymentProcess;
    @Autowired
    @Lazy
    private DeletePaymentProcess deletePaymentProcess;
}