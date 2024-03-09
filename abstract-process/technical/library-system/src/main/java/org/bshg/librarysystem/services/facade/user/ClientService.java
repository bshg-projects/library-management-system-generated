package org.bshg.librarysystem.services.facade.user;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.utils.service.IService;
import java.util.List;
public interface ClientService extends IService<Client> {
}