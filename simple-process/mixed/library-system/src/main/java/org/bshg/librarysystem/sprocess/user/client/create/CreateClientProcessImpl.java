package org.bshg.librarysystem.sprocess.user.client.create;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.sprocess.event.payment.create.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.transaction.create.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.library.loan.create.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.reservation.create.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.create.CreateReviewProcess;
import org.bshg.librarysystem.utils.sprocess.ProcessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CreateClientProcessImpl implements CreateClientProcess {
    @Transactional(rollbackFor = Exception.class)
    public Client run(Client item) {
// Your Creation Logic For 'Client'
        item = service.create(item);
        createAssociatedList(item);
        return item;
    }

    public List<Client> run(List<Client> items) {
        items.forEach(this::run);
        return items;
    }

    public void createAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        ProcessHelper.createList(item, Client::getLoans, Loan::setClient, createLoanProcess::run);
        ProcessHelper.createList(item, Client::getReservations, Reservation::setClient, createReservationProcess::run);
        ProcessHelper.createList(item, Client::getReviews, Review::setClient, createReviewProcess::run);
        ProcessHelper.createList(item, Client::getTransactions, Transaction::setClient, createTransactionProcess::run);
        ProcessHelper.createList(item, Client::getPayments, Payment::setClient, createPaymentProcess::run);
    }

    @Autowired
    private ClientService service;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    @Lazy
    private CreateReservationProcess createReservationProcess;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    @Lazy
    private CreatePaymentProcess createPaymentProcess;
    @Autowired
    private LoanService loanService;
    @Autowired
    @Lazy
    private CreateLoanProcess createLoanProcess;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    @Lazy
    private CreateTransactionProcess createTransactionProcess;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    @Lazy
    private CreateReviewProcess createReviewProcess;
}