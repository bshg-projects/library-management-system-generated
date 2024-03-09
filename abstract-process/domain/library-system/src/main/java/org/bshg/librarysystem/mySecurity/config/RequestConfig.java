package org.bshg.librarysystem.mySecurity.config;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.bshg.librarysystem.mySecurity.permissions.resources.*;
import org.bshg.librarysystem.mySecurity.permissions.RoleEnum;
import static org.springframework.http.HttpMethod.*;
public class RequestConfig {
private RequestConfig() {}
private static HttpSecurity http;
public static void set(HttpSecurity http) throws Exception {
if (RequestConfig.http == null) RequestConfig.http = http;
staffAuthorizeHttpRequests();
clientAuthorizeHttpRequests();
employeeAssignmentAuthorizeHttpRequests();
adminAuthorizeHttpRequests();
employeeAuthorizeHttpRequests();
authorBookAuthorizeHttpRequests();
authorAuthorizeHttpRequests();
bookAuthorizeHttpRequests();
genreAuthorizeHttpRequests();
publisherAuthorizeHttpRequests();
categoryAuthorizeHttpRequests();
magazineAuthorizeHttpRequests();
loanAuthorizeHttpRequests();
reservationAuthorizeHttpRequests();
reviewAuthorizeHttpRequests();
libraryBranchAuthorizeHttpRequests();
addressAuthorizeHttpRequests();
countryAuthorizeHttpRequests();
membershipAuthorizeHttpRequests();
moneyAuthorizeHttpRequests();
eventAuthorizeHttpRequests();
transactionAuthorizeHttpRequests();
paymentAuthorizeHttpRequests();
shelfAuthorizeHttpRequests();
rackAuthorizeHttpRequests();
bookGenreAuthorizeHttpRequests();
userAuthorizeHttpRequests();
roleAuthorizeHttpRequests();
defaultAuthorizeHttpRequests();
}
private static void userAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/user/**").hasAnyAuthority(UserPermission.READ.authority())
.requestMatchers(POST, "/api/v1/user/**").hasAnyAuthority(UserPermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/user/**").hasAnyAuthority(UserPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/user/**").hasAnyAuthority(UserPermission.DELETE.authority())
.requestMatchers("/api/v1/user/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void roleAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/v1/role/**").hasAnyAuthority(RolePermission.READ.authority())
.requestMatchers(POST, "/api/v1/role/**").hasAnyAuthority(RolePermission.CREATE.authority())
.requestMatchers(PUT, "/api/v1/role/**").hasAnyAuthority(RolePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/v1/role/**").hasAnyAuthority(RolePermission.DELETE.authority())
.requestMatchers("/api/v1/role/**").hasAnyRole(RoleEnum.ADMIN.name())
);
}
private static void staffAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/staff/**").hasAnyAuthority(StaffPermission.READ.authority())
.requestMatchers(POST, "/api/staff/**").hasAnyAuthority(StaffPermission.CREATE.authority())
.requestMatchers(PUT, "/api/staff/**").hasAnyAuthority(StaffPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/staff/**").hasAnyAuthority(StaffPermission.DELETE.authority())
.requestMatchers("/api/staff/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name())
);
}
private static void clientAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/client/**").hasAnyAuthority(ClientPermission.READ.authority())
.requestMatchers(POST, "/api/client/**").hasAnyAuthority(ClientPermission.CREATE.authority())
.requestMatchers(PUT, "/api/client/**").hasAnyAuthority(ClientPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/client/**").hasAnyAuthority(ClientPermission.DELETE.authority())
.requestMatchers("/api/client/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name())
);
}
private static void employeeAssignmentAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/employeeassignment/**").hasAnyAuthority(EmployeeAssignmentPermission.READ.authority())
.requestMatchers(POST, "/api/employeeassignment/**").hasAnyAuthority(EmployeeAssignmentPermission.CREATE.authority())
.requestMatchers(PUT, "/api/employeeassignment/**").hasAnyAuthority(EmployeeAssignmentPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/employeeassignment/**").hasAnyAuthority(EmployeeAssignmentPermission.DELETE.authority())
.requestMatchers("/api/employeeassignment/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void adminAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/admin/**").hasAnyAuthority(AdminPermission.READ.authority())
.requestMatchers(POST, "/api/admin/**").hasAnyAuthority(AdminPermission.CREATE.authority())
.requestMatchers(PUT, "/api/admin/**").hasAnyAuthority(AdminPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/admin/**").hasAnyAuthority(AdminPermission.DELETE.authority())
.requestMatchers("/api/admin/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void employeeAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/employee/**").hasAnyAuthority(EmployeePermission.READ.authority())
.requestMatchers(POST, "/api/employee/**").hasAnyAuthority(EmployeePermission.CREATE.authority())
.requestMatchers(PUT, "/api/employee/**").hasAnyAuthority(EmployeePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/employee/**").hasAnyAuthority(EmployeePermission.DELETE.authority())
.requestMatchers("/api/employee/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void authorBookAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/authorbook/**").authenticated()
.requestMatchers(POST, "/api/authorbook/**").hasAnyAuthority(AuthorBookPermission.CREATE.authority())
.requestMatchers(PUT, "/api/authorbook/**").hasAnyAuthority(AuthorBookPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/authorbook/**").hasAnyAuthority(AuthorBookPermission.DELETE.authority())
.requestMatchers("/api/authorbook/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void authorAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/author/**").authenticated()
.requestMatchers(POST, "/api/author/**").hasAnyAuthority(AuthorPermission.CREATE.authority())
.requestMatchers(PUT, "/api/author/**").hasAnyAuthority(AuthorPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/author/**").hasAnyAuthority(AuthorPermission.DELETE.authority())
.requestMatchers("/api/author/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void bookAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/book/**").authenticated()
.requestMatchers(POST, "/api/book/**").hasAnyAuthority(BookPermission.CREATE.authority())
.requestMatchers(PUT, "/api/book/**").hasAnyAuthority(BookPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/book/**").hasAnyAuthority(BookPermission.DELETE.authority())
.requestMatchers("/api/book/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void genreAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/genre/**").authenticated()
.requestMatchers(POST, "/api/genre/**").hasAnyAuthority(GenrePermission.CREATE.authority())
.requestMatchers(PUT, "/api/genre/**").hasAnyAuthority(GenrePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/genre/**").hasAnyAuthority(GenrePermission.DELETE.authority())
.requestMatchers("/api/genre/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void publisherAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/publisher/**").authenticated()
.requestMatchers(POST, "/api/publisher/**").hasAnyAuthority(PublisherPermission.CREATE.authority())
.requestMatchers(PUT, "/api/publisher/**").hasAnyAuthority(PublisherPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/publisher/**").hasAnyAuthority(PublisherPermission.DELETE.authority())
.requestMatchers("/api/publisher/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void categoryAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/category/**").authenticated()
.requestMatchers(POST, "/api/category/**").hasAnyAuthority(CategoryPermission.CREATE.authority())
.requestMatchers(PUT, "/api/category/**").hasAnyAuthority(CategoryPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/category/**").hasAnyAuthority(CategoryPermission.DELETE.authority())
.requestMatchers("/api/category/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void magazineAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/magazine/**").authenticated()
.requestMatchers(POST, "/api/magazine/**").hasAnyAuthority(MagazinePermission.CREATE.authority())
.requestMatchers(PUT, "/api/magazine/**").hasAnyAuthority(MagazinePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/magazine/**").hasAnyAuthority(MagazinePermission.DELETE.authority())
.requestMatchers("/api/magazine/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void loanAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/loan/**").authenticated()
.requestMatchers(POST, "/api/loan/**").hasAnyAuthority(LoanPermission.CREATE.authority())
.requestMatchers(PUT, "/api/loan/**").hasAnyAuthority(LoanPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/loan/**").hasAnyAuthority(LoanPermission.DELETE.authority())
.requestMatchers("/api/loan/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void reservationAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/reservation/**").authenticated()
.requestMatchers(POST, "/api/reservation/**").hasAnyAuthority(ReservationPermission.CREATE.authority())
.requestMatchers(PUT, "/api/reservation/**").hasAnyAuthority(ReservationPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/reservation/**").hasAnyAuthority(ReservationPermission.DELETE.authority())
.requestMatchers("/api/reservation/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void reviewAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/review/**").authenticated()
.requestMatchers(POST, "/api/review/**").hasAnyAuthority(ReviewPermission.CREATE.authority())
.requestMatchers(PUT, "/api/review/**").hasAnyAuthority(ReviewPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/review/**").hasAnyAuthority(ReviewPermission.DELETE.authority())
.requestMatchers("/api/review/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void libraryBranchAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/librarybranch/**").authenticated()
.requestMatchers(POST, "/api/librarybranch/**").hasAnyAuthority(LibraryBranchPermission.CREATE.authority())
.requestMatchers(PUT, "/api/librarybranch/**").hasAnyAuthority(LibraryBranchPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/librarybranch/**").hasAnyAuthority(LibraryBranchPermission.DELETE.authority())
.requestMatchers("/api/librarybranch/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void addressAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/address/**").authenticated()
.requestMatchers(POST, "/api/address/**").hasAnyAuthority(AddressPermission.CREATE.authority())
.requestMatchers(PUT, "/api/address/**").hasAnyAuthority(AddressPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/address/**").hasAnyAuthority(AddressPermission.DELETE.authority())
.requestMatchers("/api/address/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void countryAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/country/**").authenticated()
.requestMatchers(POST, "/api/country/**").hasAnyAuthority(CountryPermission.CREATE.authority())
.requestMatchers(PUT, "/api/country/**").hasAnyAuthority(CountryPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/country/**").hasAnyAuthority(CountryPermission.DELETE.authority())
.requestMatchers("/api/country/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void membershipAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/membership/**").authenticated()
.requestMatchers(POST, "/api/membership/**").hasAnyAuthority(MembershipPermission.CREATE.authority())
.requestMatchers(PUT, "/api/membership/**").hasAnyAuthority(MembershipPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/membership/**").hasAnyAuthority(MembershipPermission.DELETE.authority())
.requestMatchers("/api/membership/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void moneyAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/money/**").hasAnyAuthority(MoneyPermission.READ.authority())
.requestMatchers(POST, "/api/money/**").hasAnyAuthority(MoneyPermission.CREATE.authority())
.requestMatchers(PUT, "/api/money/**").hasAnyAuthority(MoneyPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/money/**").hasAnyAuthority(MoneyPermission.DELETE.authority())
.requestMatchers("/api/money/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void eventAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/event/**").authenticated()
.requestMatchers(POST, "/api/event/**").hasAnyAuthority(EventPermission.CREATE.authority())
.requestMatchers(PUT, "/api/event/**").hasAnyAuthority(EventPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/event/**").hasAnyAuthority(EventPermission.DELETE.authority())
.requestMatchers("/api/event/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void transactionAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/transaction/**").authenticated()
.requestMatchers(POST, "/api/transaction/**").hasAnyAuthority(TransactionPermission.CREATE.authority())
.requestMatchers(PUT, "/api/transaction/**").hasAnyAuthority(TransactionPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/transaction/**").hasAnyAuthority(TransactionPermission.DELETE.authority())
.requestMatchers("/api/transaction/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void paymentAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/payment/**").authenticated()
.requestMatchers(POST, "/api/payment/**").hasAnyAuthority(PaymentPermission.CREATE.authority())
.requestMatchers(PUT, "/api/payment/**").hasAnyAuthority(PaymentPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/payment/**").hasAnyAuthority(PaymentPermission.DELETE.authority())
.requestMatchers("/api/payment/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void shelfAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/shelf/**").authenticated()
.requestMatchers(POST, "/api/shelf/**").hasAnyAuthority(ShelfPermission.CREATE.authority())
.requestMatchers(PUT, "/api/shelf/**").hasAnyAuthority(ShelfPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/shelf/**").hasAnyAuthority(ShelfPermission.DELETE.authority())
.requestMatchers("/api/shelf/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void rackAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/rack/**").authenticated()
.requestMatchers(POST, "/api/rack/**").hasAnyAuthority(RackPermission.CREATE.authority())
.requestMatchers(PUT, "/api/rack/**").hasAnyAuthority(RackPermission.EDIT.authority())
.requestMatchers(DELETE, "/api/rack/**").hasAnyAuthority(RackPermission.DELETE.authority())
.requestMatchers("/api/rack/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void bookGenreAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers(GET, "/api/bookgenre/**").authenticated()
.requestMatchers(POST, "/api/bookgenre/**").hasAnyAuthority(BookGenrePermission.CREATE.authority())
.requestMatchers(PUT, "/api/bookgenre/**").hasAnyAuthority(BookGenrePermission.EDIT.authority())
.requestMatchers(DELETE, "/api/bookgenre/**").hasAnyAuthority(BookGenrePermission.DELETE.authority())
.requestMatchers("/api/bookgenre/**").hasAnyRole(RoleEnum.ADMIN.name(),RoleEnum.EMPLOYEE.name(),RoleEnum.CLIENT.name())
);
}
private static void defaultAuthorizeHttpRequests() throws Exception {
http.authorizeHttpRequests(auth -> auth
.requestMatchers("/login").permitAll()
.requestMatchers("/api/login").permitAll()
.requestMatchers("/api/**").authenticated()
.anyRequest().authenticated());
}
}