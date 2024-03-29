package org.bshg.librarysystem;

import org.bshg.librarysystem.entity.core.content.*;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.entity.core.library.*;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.mySecurity.entity.Role;
import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import org.bshg.librarysystem.mySecurity.service.facade.RoleService;
import org.bshg.librarysystem.mySecurity.service.facade.UserService;
import org.bshg.librarysystem.sprocess.content.author.facade.CreateAuthorProcess;
import org.bshg.librarysystem.sprocess.content.authorbook.facade.CreateAuthorBookProcess;
import org.bshg.librarysystem.sprocess.content.book.facade.CreateBookProcess;
import org.bshg.librarysystem.sprocess.content.bookgenre.facade.CreateBookGenreProcess;
import org.bshg.librarysystem.sprocess.content.category.facade.CreateCategoryProcess;
import org.bshg.librarysystem.sprocess.content.genre.facade.CreateGenreProcess;
import org.bshg.librarysystem.sprocess.content.magazine.facade.CreateMagazineProcess;
import org.bshg.librarysystem.sprocess.content.publisher.facade.CreatePublisherProcess;
import org.bshg.librarysystem.sprocess.event.event.facade.CreateEventProcess;
import org.bshg.librarysystem.sprocess.event.payment.facade.CreatePaymentProcess;
import org.bshg.librarysystem.sprocess.event.transaction.facade.CreateTransactionProcess;
import org.bshg.librarysystem.sprocess.library.address.facade.CreateAddressProcess;
import org.bshg.librarysystem.sprocess.library.country.facade.CreateCountryProcess;
import org.bshg.librarysystem.sprocess.library.librarybranch.facade.CreateLibraryBranchProcess;
import org.bshg.librarysystem.sprocess.library.loan.facade.CreateLoanProcess;
import org.bshg.librarysystem.sprocess.library.membership.facade.CreateMembershipProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.review.facade.CreateReviewProcess;
import org.bshg.librarysystem.sprocess.storage.rack.facade.CreateRackProcess;
import org.bshg.librarysystem.sprocess.storage.shelf.facade.CreateShelfProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.facade.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employeeassignment.facade.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.staff.facade.CreateStaffProcess;
import org.bshg.librarysystem.utils.console.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Value("${app.data-loader.load}")
    private boolean load;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (load) {
            Console.log("Data Loading...");
            generatePermission();
            generateAdminAccount();
            generateEmployeeAccount();
            generateClientAccount();
            generateStaff();
            generateClient();
            generateEmployeeAssignment();
            generateAdmin();
            generateEmployee();
            generateAuthorBook();
            generateAuthor();
            generateBook();
            generateGenre();
            generatePublisher();
            generateCategory();
            generateMagazine();
            generateLoan();
            generateReservation();
            generateReview();
            generateLibraryBranch();
            generateAddress();
            generateCountry();
            generateMembership();
            generateEvent();
            generateTransaction();
            generatePayment();
            generateShelf();
            generateRack();
            generateBookGenre();
            Console.log("Data Loaded!");
        }
    }

    private void generatePermission() {
        for (RoleEnum role : RoleEnum.values()) {
            var roleEntity = role.getRole();
            roleService.save(roleEntity);
        }
    }

    private void generateAdminAccount() {
        User user = new User("admin");
        user.setPassword("123");
        Role role = new Role();
        role.setName(RoleEnum.ADMIN.name());
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);
        userService.save(user);
        Console.log("One Account For ADMIN role is created: 'admin' :: '123'");
    }

    private void generateEmployeeAccount() {
        User user = new User("employee");
        user.setPassword("123");
        Role role = new Role();
        role.setName(RoleEnum.EMPLOYEE.name());
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);
        userService.save(user);
        Console.log("One Account For EMPLOYEE role is created: 'employee' :: '123'");
    }

    private void generateClientAccount() {
        User user = new User("client");
        user.setPassword("123");
        Role role = new Role();
        role.setName(RoleEnum.CLIENT.name());
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);
        userService.save(user);
        Console.log("One Account For CLIENT role is created: 'client' :: '123'");
    }

    private void generateStaff() {
        for (int i = 0; i < 50; i++) {
            Staff item = new Staff();
            item.setFirstName("firstName " + i);
            item.setLastName("lastName " + i);
            item.setPosition("position " + i);
            item.setSalary("salary " + i);
            item.setUsername("employee " + i);
            item.setPassword(userService.cryptPassword("employee " + i));
            List<Role> savedRoles = roleService.save(item.getRoles());
            item.setRoles(savedRoles);
            createStaffProcess.run(item);
        }
        Console.log("Data For Staff Generated!");
    }

    private void generateClient() {
        for (int i = 0; i < 50; i++) {
            Client item = new Client();
            item.setFirstName("firstName " + i);
            item.setLastName("lastName " + i);
            item.setUsername("client " + i);
            item.setPassword(userService.cryptPassword("client " + i));
            List<Role> savedRoles = roleService.save(item.getRoles());
            item.setRoles(savedRoles);
            createClientProcess.run(item);
        }
        Console.log("Data For Client Generated!");
    }

    private void generateEmployeeAssignment() {
        for (int i = 0; i < 50; i++) {
            EmployeeAssignment item = new EmployeeAssignment();
            createEmployeeAssignmentProcess.run(item);
        }
        Console.log("Data For EmployeeAssignment Generated!");
    }

    private void generateAdmin() {
        for (int i = 0; i < 50; i++) {
            Admin item = new Admin();
            item.setFirstName("firstName " + i);
            item.setLastName("lastName " + i);
            item.setUsername("admin " + i);
            item.setPassword(userService.cryptPassword("admin " + i));
            List<Role> savedRoles = roleService.save(item.getRoles());
            item.setRoles(savedRoles);
            createAdminProcess.run(item);
        }
        Console.log("Data For Admin Generated!");
    }

    private void generateEmployee() {
        for (int i = 0; i < 50; i++) {
            Employee item = new Employee();
            item.setFirstName("firstName " + i);
            item.setLastName("lastName " + i);
            item.setBiography("biography " + i);
            item.setPosition("position " + i);
            item.setSalary("salary " + i);
            item.setUsername("employee " + i);
            item.setPassword(userService.cryptPassword("employee " + i));
            List<Role> savedRoles = roleService.save(item.getRoles());
            item.setRoles(savedRoles);
            createEmployeeProcess.run(item);
        }
        Console.log("Data For Employee Generated!");
    }

    private void generateAuthorBook() {
        for (int i = 0; i < 50; i++) {
            AuthorBook item = new AuthorBook();
            createAuthorBookProcess.run(item);
        }
        Console.log("Data For AuthorBook Generated!");
    }

    private void generateAuthor() {
        for (int i = 0; i < 50; i++) {
            Author item = new Author();
            item.setFirstName("firstName " + i);
            item.setLastName("lastName " + i);
            item.setNationality("nationality " + i);
            item.setBiography("biography " + i);
            createAuthorProcess.run(item);
        }
        Console.log("Data For Author Generated!");
    }

    private void generateBook() {
        for (int i = 0; i < 50; i++) {
            Book item = new Book();
            item.setTitle("title " + i);
            item.setIsbn("isbn " + i);
            item.setDescription("description " + i);
            createBookProcess.run(item);
        }
        Console.log("Data For Book Generated!");
    }

    private void generateGenre() {
        for (int i = 0; i < 50; i++) {
            Genre item = new Genre();
            item.setName("name " + i);
            createGenreProcess.run(item);
        }
        Console.log("Data For Genre Generated!");
    }

    private void generatePublisher() {
        for (int i = 0; i < 50; i++) {
            Publisher item = new Publisher();
            item.setName("name " + i);
            createPublisherProcess.run(item);
        }
        Console.log("Data For Publisher Generated!");
    }

    private void generateCategory() {
        for (int i = 0; i < 50; i++) {
            Category item = new Category();
            item.setName("name " + i);
            createCategoryProcess.run(item);
        }
        Console.log("Data For Category Generated!");
    }

    private void generateMagazine() {
        for (int i = 0; i < 50; i++) {
            Magazine item = new Magazine();
            item.setTitle("title " + i);
            createMagazineProcess.run(item);
        }
        Console.log("Data For Magazine Generated!");
    }

    private void generateLoan() {
        for (int i = 0; i < 50; i++) {
            Loan item = new Loan();
            item.setName("name " + i);
            createLoanProcess.run(item);
        }
        Console.log("Data For Loan Generated!");
    }

    private void generateReservation() {
        for (int i = 0; i < 50; i++) {
            Reservation item = new Reservation();
            item.setName("name " + i);
            createReservationProcess.run(item);
        }
        Console.log("Data For Reservation Generated!");
    }

    private void generateReview() {
        for (int i = 0; i < 50; i++) {
            Review item = new Review();
            item.setName("name " + i);
            item.setComment("comment " + i);
            createReviewProcess.run(item);
        }
        Console.log("Data For Review Generated!");
    }

    private void generateLibraryBranch() {
        for (int i = 0; i < 50; i++) {
            LibraryBranch item = new LibraryBranch();
            item.setName("name " + i);
            createLibraryBranchProcess.run(item);
        }
        Console.log("Data For LibraryBranch Generated!");
    }

    private void generateAddress() {
        for (int i = 0; i < 50; i++) {
            Address item = new Address();
            item.setStreet("street " + i);
            item.setCity("city " + i);
            item.setState("state " + i);
            item.setZipCode("zipCode " + i);
            createAddressProcess.run(item);
        }
        Console.log("Data For Address Generated!");
    }

    private void generateCountry() {
        for (int i = 0; i < 50; i++) {
            Country item = new Country();
            item.setName("name " + i);
            createCountryProcess.run(item);
        }
        Console.log("Data For Country Generated!");
    }

    private void generateMembership() {
        for (int i = 0; i < 50; i++) {
            Membership item = new Membership();
            item.setName("name " + i);
            createMembershipProcess.run(item);
        }
        Console.log("Data For Membership Generated!");
    }

    private void generateEvent() {
        for (int i = 0; i < 50; i++) {
            Event item = new Event();
            item.setName("name " + i);
            item.setLocation("location " + i);
            createEventProcess.run(item);
        }
        Console.log("Data For Event Generated!");
    }

    private void generateTransaction() {
        for (int i = 0; i < 50; i++) {
            Transaction item = new Transaction();
            createTransactionProcess.run(item);
        }
        Console.log("Data For Transaction Generated!");
    }

    private void generatePayment() {
        for (int i = 0; i < 50; i++) {
            Payment item = new Payment();
            createPaymentProcess.run(item);
        }
        Console.log("Data For Payment Generated!");
    }

    private void generateShelf() {
        for (int i = 0; i < 50; i++) {
            Shelf item = new Shelf();
            item.setShelfNumber("shelfNumber " + i);
            createShelfProcess.run(item);
        }
        Console.log("Data For Shelf Generated!");
    }

    private void generateRack() {
        for (int i = 0; i < 50; i++) {
            Rack item = new Rack();
            item.setRackNumber("rackNumber " + i);
            createRackProcess.run(item);
        }
        Console.log("Data For Rack Generated!");
    }

    private void generateBookGenre() {
        for (int i = 0; i < 50; i++) {
            BookGenre item = new BookGenre();
            createBookGenreProcess.run(item);
        }
        Console.log("Data For BookGenre Generated!");
    }

    @Autowired
    private CreateStaffProcess createStaffProcess;
    @Autowired
    private CreateClientProcess createClientProcess;
    @Autowired
    private CreateEmployeeAssignmentProcess createEmployeeAssignmentProcess;
    @Autowired
    private CreateAdminProcess createAdminProcess;
    @Autowired
    private CreateEmployeeProcess createEmployeeProcess;
    @Autowired
    private CreateAuthorBookProcess createAuthorBookProcess;
    @Autowired
    private CreateAuthorProcess createAuthorProcess;
    @Autowired
    private CreateBookProcess createBookProcess;
    @Autowired
    private CreateGenreProcess createGenreProcess;
    @Autowired
    private CreatePublisherProcess createPublisherProcess;
    @Autowired
    private CreateCategoryProcess createCategoryProcess;
    @Autowired
    private CreateMagazineProcess createMagazineProcess;
    @Autowired
    private CreateLoanProcess createLoanProcess;
    @Autowired
    private CreateReservationProcess createReservationProcess;
    @Autowired
    private CreateReviewProcess createReviewProcess;
    @Autowired
    private CreateLibraryBranchProcess createLibraryBranchProcess;
    @Autowired
    private CreateAddressProcess createAddressProcess;
    @Autowired
    private CreateCountryProcess createCountryProcess;
    @Autowired
    private CreateMembershipProcess createMembershipProcess;
    @Autowired
    private CreateEventProcess createEventProcess;
    @Autowired
    private CreateTransactionProcess createTransactionProcess;
    @Autowired
    private CreatePaymentProcess createPaymentProcess;
    @Autowired
    private CreateShelfProcess createShelfProcess;
    @Autowired
    private CreateRackProcess createRackProcess;
    @Autowired
    private CreateBookGenreProcess createBookGenreProcess;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
}