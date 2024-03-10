package org.bshg.librarysystem.services.user.client;

import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.repository.user.ClientDao;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.services.library.membership.MembershipService;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<Client, ClientDao> implements ClientService {
    public ClientServiceImpl(ClientDao dao) {
        super(dao);
    }

    @Override
    public void deleteAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        loanService.deleteByClientId(item.getId());
        reservationService.deleteByClientId(item.getId());
        reviewService.deleteByClientId(item.getId());
        transactionService.deleteByClientId(item.getId());
        paymentService.deleteByClientId(item.getId());
    }

    @Override
    public void deleteAssociatedObjects(Client item) {
        if (item == null || item.getId() == null) return;
        membershipService.deleteByClientId(item.getId());
    }

    @Override
    public void createAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Client::getLoans, Loan::setClient, loanService);
        ServiceHelper.createList(item, Client::getReservations, Reservation::setClient, reservationService);
        ServiceHelper.createList(item, Client::getReviews, Review::setClient, reviewService);
        ServiceHelper.createList(item, Client::getTransactions, Transaction::setClient, transactionService);
        ServiceHelper.createList(item, Client::getPayments, Payment::setClient, paymentService);
    }

    @Override
    public void updateAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(item, loanService::findByClientId, Client::getLoans, Loan::setClient, loanService);
        ServiceHelper.updateList(item, reservationService::findByClientId, Client::getReservations, Reservation::setClient, reservationService);
        ServiceHelper.updateList(item, reviewService::findByClientId, Client::getReviews, Review::setClient, reviewService);
        ServiceHelper.updateList(item, transactionService::findByClientId, Client::getTransactions, Transaction::setClient, transactionService);
        ServiceHelper.updateList(item, paymentService::findByClientId, Client::getPayments, Payment::setClient, paymentService);
    }

    @Lazy
    @Autowired
    private LoanService loanService;
    @Lazy
    @Autowired
    private ReservationService reservationService;
    @Lazy
    @Autowired
    private ReviewService reviewService;
    @Lazy
    @Autowired
    private TransactionService transactionService;
    @Lazy
    @Autowired
    private PaymentService paymentService;
    @Lazy
    @Autowired
    private MembershipService membershipService;
}