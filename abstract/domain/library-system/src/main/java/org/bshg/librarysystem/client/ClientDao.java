package org.bshg.librarysystem.client;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientDao extends Repository<Client, Long> {
}