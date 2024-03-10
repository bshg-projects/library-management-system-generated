package org.bshg.librarysystem.client.webservice;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.loan.webservice.LoanConverter;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.payment.webservice.PaymentConverter;
import org.bshg.librarysystem.reservation.webservice.ReservationConverter;
import org.bshg.librarysystem.review.webservice.ReviewConverter;
import org.bshg.librarysystem.transaction.webservice.TransactionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientConverter {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ReservationConverter reservationConverter;
    @Autowired
    private PaymentConverter paymentConverter;
    @Autowired
    private LoanConverter loanConverter;
    @Autowired
    private TransactionConverter transactionConverter;
    @Autowired
    private ReviewConverter reviewConverter;
    private boolean loans = true;
    private boolean reservations = true;
    private boolean reviews = true;
    private boolean transactions = true;
    private boolean payments = true;

    protected void convertersConfig(boolean value) {
        this.reservationConverter.setClient(value);
        this.paymentConverter.setClient(value);
        this.loanConverter.setClient(value);
        this.transactionConverter.setClient(value);
        this.reviewConverter.setClient(value);
    }

    public final ClientDto toDto(Client item) {
        this.convertersConfig(false);
        var dto = item != null ? convertToDto(item) : null;
        this.convertersConfig(true);
        return dto;
    }

    public final Client toItem(ClientDto d) {
        return d != null ? convertToItem(d) : null;
    }

    public final List<Client> toItem(List<ClientDto> dtos) {
        if (dtos == null) return null;
        List<Client> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<ClientDto> toDto(List<Client> items) {
        if (items == null) return null;
        List<ClientDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    protected Client convertToItem(ClientDto dto) {
        var item = new Client();
        userConverter.convertToChildItem(dto, item);
        item.setFirstName(dto.getFirstName());
        item.setLastName(dto.getLastName());
        item.setDateOfBirth(dto.getDateOfBirth());
        item.setLoans(loanConverter.toItem(dto.getLoans()));
        item.setReservations(reservationConverter.toItem(dto.getReservations()));
        item.setReviews(reviewConverter.toItem(dto.getReviews()));
        item.setTransactions(transactionConverter.toItem(dto.getTransactions()));
        item.setPayments(paymentConverter.toItem(dto.getPayments()));
        return item;
    }

    protected ClientDto convertToDto(Client item) {
        var dto = new ClientDto();
        userConverter.convertToChildDto(item, dto);
        dto.setFirstName(item.getFirstName());
        dto.setLastName(item.getLastName());
        dto.setDateOfBirth(item.getDateOfBirth());
        dto.setLoans(loans ? loanConverter.toDto(item.getLoans()) : null);
        dto.setReservations(reservations ? reservationConverter.toDto(item.getReservations()) : null);
        dto.setReviews(reviews ? reviewConverter.toDto(item.getReviews()) : null);
        dto.setTransactions(transactions ? transactionConverter.toDto(item.getTransactions()) : null);
        dto.setPayments(payments ? paymentConverter.toDto(item.getPayments()) : null);
        return dto;
    }

    public void setLoans(boolean value) {
        this.loans = value;
    }

    public void setReservations(boolean value) {
        this.reservations = value;
    }

    public void setReviews(boolean value) {
        this.reviews = value;
    }

    public void setTransactions(boolean value) {
        this.transactions = value;
    }

    public void setPayments(boolean value) {
        this.payments = value;
    }

    public void setReservationConverter(ReservationConverter value) {
        this.reservationConverter = value;
    }

    public ReservationConverter getReservationConverter() {
        return reservationConverter;
    }

    public void setPaymentConverter(PaymentConverter value) {
        this.paymentConverter = value;
    }

    public PaymentConverter getPaymentConverter() {
        return paymentConverter;
    }

    public void setLoanConverter(LoanConverter value) {
        this.loanConverter = value;
    }

    public LoanConverter getLoanConverter() {
        return loanConverter;
    }

    public void setTransactionConverter(TransactionConverter value) {
        this.transactionConverter = value;
    }

    public TransactionConverter getTransactionConverter() {
        return transactionConverter;
    }

    public void setReviewConverter(ReviewConverter value) {
        this.reviewConverter = value;
    }

    public ReviewConverter getReviewConverter() {
        return reviewConverter;
    }
}