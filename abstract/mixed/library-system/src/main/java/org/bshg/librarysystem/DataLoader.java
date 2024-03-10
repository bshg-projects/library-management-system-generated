package org.bshg.librarysystem;

import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.entity.Role;
import org.bshg.librarysystem.mySecurity.service.facade.UserService;
import org.bshg.librarysystem.mySecurity.service.facade.RoleService;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.user.client.ClientService;
import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.user.admin.employeeassignment.EmployeeAssignmentService;
import org.bshg.librarysystem.entity.core.user.admin.EmployeeAssignment;
import org.bshg.librarysystem.services.user.admin.admin.AdminService;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.content.authorbook.AuthorBookService;
import org.bshg.librarysystem.entity.core.content.AuthorBook;
import org.bshg.librarysystem.services.content.author.AuthorService;
import org.bshg.librarysystem.entity.core.content.Author;
import org.bshg.librarysystem.services.content.book.BookService;
import org.bshg.librarysystem.entity.core.content.Book;
import org.bshg.librarysystem.services.content.genre.GenreService;
import org.bshg.librarysystem.entity.core.content.Genre;
import org.bshg.librarysystem.services.content.publisher.PublisherService;
import org.bshg.librarysystem.entity.core.content.Publisher;
import org.bshg.librarysystem.services.content.category.CategoryService;
import org.bshg.librarysystem.entity.core.content.Category;
import org.bshg.librarysystem.services.content.magazine.MagazineService;
import org.bshg.librarysystem.entity.core.content.Magazine;
import org.bshg.librarysystem.services.library.loan.LoanService;
import org.bshg.librarysystem.entity.core.library.Loan;
import org.bshg.librarysystem.services.library.reservation.ReservationService;
import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.library.review.ReviewService;
import org.bshg.librarysystem.entity.core.library.Review;
import org.bshg.librarysystem.services.library.librarybranch.LibraryBranchService;
import org.bshg.librarysystem.entity.core.library.LibraryBranch;
import org.bshg.librarysystem.services.library.address.AddressService;
import org.bshg.librarysystem.entity.core.library.Address;
import org.bshg.librarysystem.services.library.country.CountryService;
import org.bshg.librarysystem.entity.core.library.Country;
import org.bshg.librarysystem.services.library.membership.MembershipService;
import org.bshg.librarysystem.entity.core.library.Membership;
import org.bshg.librarysystem.services.event.event.EventService;
import org.bshg.librarysystem.entity.core.event.Event;
import org.bshg.librarysystem.services.event.transaction.TransactionService;
import org.bshg.librarysystem.entity.core.event.Transaction;
import org.bshg.librarysystem.services.event.payment.PaymentService;
import org.bshg.librarysystem.entity.core.event.Payment;
import org.bshg.librarysystem.services.storage.shelf.ShelfService;
import org.bshg.librarysystem.entity.core.storage.Shelf;
import org.bshg.librarysystem.services.storage.rack.RackService;
import org.bshg.librarysystem.entity.core.storage.Rack;
import org.bshg.librarysystem.services.content.bookgenre.BookGenreService;
import org.bshg.librarysystem.entity.core.content.BookGenre;
import org.bshg.librarysystem.utils.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
            staffService.create(item);
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
            clientService.create(item);
        }
        Console.log("Data For Client Generated!");
    }

    private void generateEmployeeAssignment() {
        for (int i = 0; i < 50; i++) {
            EmployeeAssignment item = new EmployeeAssignment();
            employeeAssignmentService.create(item);
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
            adminService.create(item);
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
            employeeService.create(item);
        }
        Console.log("Data For Employee Generated!");
    }

    private void generateAuthorBook() {
        for (int i = 0; i < 50; i++) {
            AuthorBook item = new AuthorBook();
            authorBookService.create(item);
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
            authorService.create(item);
        }
        Console.log("Data For Author Generated!");
    }

    private void generateBook() {
        for (int i = 0; i < 50; i++) {
            Book item = new Book();
            item.setTitle("title " + i);
            item.setIsbn("isbn " + i);
            item.setDescription("description " + i);
            bookService.create(item);
        }
        Console.log("Data For Book Generated!");
    }

    private void generateGenre() {
        for (int i = 0; i < 50; i++) {
            Genre item = new Genre();
            item.setName("name " + i);
            genreService.create(item);
        }
        Console.log("Data For Genre Generated!");
    }

    private void generatePublisher() {
        for (int i = 0; i < 50; i++) {
            Publisher item = new Publisher();
            item.setName("name " + i);
            publisherService.create(item);
        }
        Console.log("Data For Publisher Generated!");
    }

    private void generateCategory() {
        for (int i = 0; i < 50; i++) {
            Category item = new Category();
            item.setName("name " + i);
            categoryService.create(item);
        }
        Console.log("Data For Category Generated!");
    }

    private void generateMagazine() {
        for (int i = 0; i < 50; i++) {
            Magazine item = new Magazine();
            item.setTitle("title " + i);
            magazineService.create(item);
        }
        Console.log("Data For Magazine Generated!");
    }

    private void generateLoan() {
        for (int i = 0; i < 50; i++) {
            Loan item = new Loan();
            item.setName("name " + i);
            loanService.create(item);
        }
        Console.log("Data For Loan Generated!");
    }

    private void generateReservation() {
        for (int i = 0; i < 50; i++) {
            Reservation item = new Reservation();
            item.setName("name " + i);
            reservationService.create(item);
        }
        Console.log("Data For Reservation Generated!");
    }

    private void generateReview() {
        for (int i = 0; i < 50; i++) {
            Review item = new Review();
            item.setName("name " + i);
            item.setComment("comment " + i);
            reviewService.create(item);
        }
        Console.log("Data For Review Generated!");
    }

    private void generateLibraryBranch() {
        for (int i = 0; i < 50; i++) {
            LibraryBranch item = new LibraryBranch();
            item.setName("name " + i);
            libraryBranchService.create(item);
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
            addressService.create(item);
        }
        Console.log("Data For Address Generated!");
    }

    private void generateCountry() {
        for (int i = 0; i < 50; i++) {
            Country item = new Country();
            item.setName("name " + i);
            countryService.create(item);
        }
        Console.log("Data For Country Generated!");
    }

    private void generateMembership() {
        for (int i = 0; i < 50; i++) {
            Membership item = new Membership();
            item.setName("name " + i);
            membershipService.create(item);
        }
        Console.log("Data For Membership Generated!");
    }

    private void generateEvent() {
        for (int i = 0; i < 50; i++) {
            Event item = new Event();
            item.setName("name " + i);
            item.setLocation("location " + i);
            eventService.create(item);
        }
        Console.log("Data For Event Generated!");
    }

    private void generateTransaction() {
        for (int i = 0; i < 50; i++) {
            Transaction item = new Transaction();
            transactionService.create(item);
        }
        Console.log("Data For Transaction Generated!");
    }

    private void generatePayment() {
        for (int i = 0; i < 50; i++) {
            Payment item = new Payment();
            paymentService.create(item);
        }
        Console.log("Data For Payment Generated!");
    }

    private void generateShelf() {
        for (int i = 0; i < 50; i++) {
            Shelf item = new Shelf();
            item.setShelfNumber("shelfNumber " + i);
            shelfService.create(item);
        }
        Console.log("Data For Shelf Generated!");
    }

    private void generateRack() {
        for (int i = 0; i < 50; i++) {
            Rack item = new Rack();
            item.setRackNumber("rackNumber " + i);
            rackService.create(item);
        }
        Console.log("Data For Rack Generated!");
    }

    private void generateBookGenre() {
        for (int i = 0; i < 50; i++) {
            BookGenre item = new BookGenre();
            bookGenreService.create(item);
        }
        Console.log("Data For BookGenre Generated!");
    }

    @Autowired
    private StaffService staffService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeAssignmentService employeeAssignmentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AuthorBookService authorBookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MagazineService magazineService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private LibraryBranchService libraryBranchService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private MembershipService membershipService;
    @Autowired
    private EventService eventService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ShelfService shelfService;
    @Autowired
    private RackService rackService;
    @Autowired
    private BookGenreService bookGenreService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
}