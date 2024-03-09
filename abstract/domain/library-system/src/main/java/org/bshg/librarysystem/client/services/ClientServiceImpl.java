
package org.bshg.librarysystem.client.services;
import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.client.ClientDao;
import org.bshg.librarysystem.client.services.ClientService;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.reservation.services.ReservationService;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.review.services.ReviewService;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.transaction.services.TransactionService;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.payment.services.PaymentService;
import org.bshg.librarysystem.membership.Membership;
import org.bshg.librarysystem.membership.services.MembershipService;
import org.bshg.librarysystem.utils.service.ServiceImpl;
import org.bshg.librarysystem.utils.service.ServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
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
ServiceHelper.updateList(item,loanService::findByClientId,Client::getLoans,Loan::setClient,loanService);
ServiceHelper.updateList(item,reservationService::findByClientId,Client::getReservations,Reservation::setClient,reservationService);
ServiceHelper.updateList(item,reviewService::findByClientId,Client::getReviews,Review::setClient,reviewService);
ServiceHelper.updateList(item,transactionService::findByClientId,Client::getTransactions,Transaction::setClient,transactionService);
ServiceHelper.updateList(item,paymentService::findByClientId,Client::getPayments,Payment::setClient,paymentService);
}
@Lazy @Autowired private LoanService loanService;
@Lazy @Autowired private ReservationService reservationService;
@Lazy @Autowired private ReviewService reviewService;
@Lazy @Autowired private TransactionService transactionService;
@Lazy @Autowired private PaymentService paymentService;
@Lazy @Autowired private MembershipService membershipService;
}