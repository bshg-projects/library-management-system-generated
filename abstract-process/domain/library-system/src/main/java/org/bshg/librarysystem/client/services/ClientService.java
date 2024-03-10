package org.bshg.librarysystem.client.services;

import org.bshg.librarysystem.client.Client;
import org.bshg.librarysystem.reservation.Reservation;
import org.bshg.librarysystem.payment.Payment;
import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.transaction.Transaction;
import org.bshg.librarysystem.review.Review;
import org.bshg.librarysystem.utils.service.IService;

import java.util.List;

public interface ClientService extends IService<Client> {
}