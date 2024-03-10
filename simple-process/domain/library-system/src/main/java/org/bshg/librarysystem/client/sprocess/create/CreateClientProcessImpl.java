package org.bshg.librarysystem.client.sprocess.create;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.loan.sprocess.create.CreateLoanProcess;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.payment.sprocess.create.CreatePaymentProcess;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.reservation.sprocess.create.CreateReservationProcess;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.review.sprocess.create.CreateReviewProcess;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.transaction.sprocess.create.CreateTransactionProcess;
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