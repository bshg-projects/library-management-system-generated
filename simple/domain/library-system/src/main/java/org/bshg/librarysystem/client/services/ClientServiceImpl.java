package org.bshg.librarysystem.client.services;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.ClientDao;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    //--------------- FIND -------------------------------------
    public Client findById(Long id) {
        return dao.findById(id).orElse(null);
    }

    public List<Client> findAll() {
        return dao.findAll();
    }

    public List<Client> findAllOptimized() {
        return findAll();
    }

    //--------------- CREATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Client create(Client item) {
        if (item == null) return null;
        Client saved = dao.save(item);
        createAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Client> create(List<Client> items) {
        List<Client> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(create(it)));
        return result;
    }

    //--------------- UPDATE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public Client update(Client item) {
        if (item == null || item.getId() == null) return null;
        Client saved = dao.save(item);
        updateAssociatedList(saved);
        return saved;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Client> update(List<Client> items) {
        List<Client> result = new ArrayList<>();
        if (items == null || items.isEmpty()) return result;
        items.forEach(it -> result.add(update(it)));
        return result;
    }

    //--------------- DELETE -----------------------------------
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        Client item = findById(id);
        if (item != null) delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Client item) {
        deleteAssociated(item);
        dao.delete(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Client> items) {
        if (items == null || items.isEmpty()) return;
        items.forEach(this::delete);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdIn(List<Long> ids) {
        ids.forEach(id -> {
            Client item = findById(id);
            if (item != null) {
                deleteAssociated(item);
            }
        });
        dao.deleteByIdIn(ids);
    }

    //--------------- FIND AND DELETE BYs ----------------------
//----------------------------------------------------------
    public void createAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.createList(item, Client::getLoans, Loan::setClient, loanService::create);
        ServiceHelper.createList(item, Client::getReservations, Reservation::setClient, reservationService::create);
        ServiceHelper.createList(item, Client::getReviews, Review::setClient, reviewService::create);
        ServiceHelper.createList(item, Client::getTransactions, Transaction::setClient, transactionService::create);
        ServiceHelper.createList(item, Client::getPayments, Payment::setClient, paymentService::create);
    }

    public void updateAssociatedList(Client item) {
        if (item == null || item.getId() == null) return;
        ServiceHelper.updateList(
                item, loanService.findByClientId(item.getId()),
                item.getLoans(), Loan::setClient,
                loanService::update,
                loanService::delete
        );
        ServiceHelper.updateList(
                item, reservationService.findByClientId(item.getId()),
                item.getReservations(), Reservation::setClient,
                reservationService::update,
                reservationService::delete
        );
        ServiceHelper.updateList(
                item, reviewService.findByClientId(item.getId()),
                item.getReviews(), Review::setClient,
                reviewService::update,
                reviewService::delete
        );
        ServiceHelper.updateList(
                item, transactionService.findByClientId(item.getId()),
                item.getTransactions(), Transaction::setClient,
                transactionService::update,
                transactionService::delete
        );
        ServiceHelper.updateList(
                item, paymentService.findByClientId(item.getId()),
                item.getPayments(), Payment::setClient,
                paymentService::update,
                paymentService::delete
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssociated(Client item) {
        deleteAssociatedList(item);
        deleteAssociatedObjects(item);
    }

    public void deleteAssociatedList(Client item) {
        loanService.deleteByClientId(item.getId());
        reservationService.deleteByClientId(item.getId());
        reviewService.deleteByClientId(item.getId());
        transactionService.deleteByClientId(item.getId());
        paymentService.deleteByClientId(item.getId());
    }

    public void deleteAssociatedObjects(Client item) {
        membershipService.deleteByClientId(item.getId());
    }

    //----------------------------------------------------------
    @Autowired
    private ClientDao dao;
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