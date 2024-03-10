package org.bshg.librarysystem.mySecurity.permissions;

import org.bshg.librarysystem.mySecurity.entity.Permission;
import org.bshg.librarysystem.mySecurity.entity.Role;
import org.bshg.librarysystem.mySecurity.permissions.resources.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleEnum {
    ADMIN(
            UserPermission.values(),
            RolePermission.values(),
            StaffPermission.values(),
            ClientPermission.values(),
            EmployeeAssignmentPermission.values(),
            AdminPermission.values(),
            EmployeePermission.values(),
            AuthorBookPermission.values(),
            AuthorPermission.values(),
            BookPermission.values(),
            GenrePermission.values(),
            PublisherPermission.values(),
            CategoryPermission.values(),
            MagazinePermission.values(),
            LoanPermission.values(),
            ReservationPermission.values(),
            ReviewPermission.values(),
            LibraryBranchPermission.values(),
            AddressPermission.values(),
            CountryPermission.values(),
            MembershipPermission.values(),
            MoneyPermission.values(),
            EventPermission.values(),
            TransactionPermission.values(),
            PaymentPermission.values(),
            ShelfPermission.values(),
            RackPermission.values(),
            BookGenrePermission.values()
    ),
    EMPLOYEE(
            StaffPermission.values(),
            ClientPermission.values(),
            EmployeeAssignmentPermission.values(),
            AdminPermission.values(),
            EmployeePermission.values(),
            AuthorBookPermission.values(),
            AuthorPermission.values(),
            BookPermission.values(),
            GenrePermission.values(),
            PublisherPermission.values(),
            CategoryPermission.values(),
            MagazinePermission.values(),
            LoanPermission.values(),
            ReservationPermission.values(),
            ReviewPermission.values(),
            LibraryBranchPermission.values(),
            AddressPermission.values(),
            CountryPermission.values(),
            MembershipPermission.values(),
            MoneyPermission.values(),
            EventPermission.values(),
            TransactionPermission.values(),
            PaymentPermission.values(),
            ShelfPermission.values(),
            RackPermission.values(),
            BookGenrePermission.values()
    ),
    CLIENT(
            EmployeeAssignmentPermission.values(),
            AdminPermission.values(),
            EmployeePermission.values(),
            AuthorBookPermission.READ,
            AuthorPermission.READ,
            BookPermission.READ,
            GenrePermission.READ,
            PublisherPermission.READ,
            CategoryPermission.READ,
            MagazinePermission.READ,
            LoanPermission.READ,
            ReservationPermission.READ,
            ReviewPermission.READ,
            LibraryBranchPermission.READ,
            AddressPermission.READ,
            CountryPermission.READ,
            MembershipPermission.READ,
            MoneyPermission.values(),
            EventPermission.READ,
            TransactionPermission.READ,
            PaymentPermission.READ,
            ShelfPermission.READ,
            RackPermission.READ,
            BookGenrePermission.READ
    ),
    ;
    private Set<PermissionResource> permissions = null;

    RoleEnum() {
    }

    RoleEnum(Object... permissionsList) {
        this.permissions = Arrays.stream(permissionsList)
                .flatMap(o -> {
                    if (o instanceof PermissionResource[]) {
                        return Arrays.stream((PermissionResource[]) o);
                    } else if (o instanceof PermissionResource) {
                        return Arrays.stream(new PermissionResource[]{(PermissionResource) o});
                    } else {
                        throw new IllegalArgumentException("Unsupported type in permissionsList");
                    }
                }).collect(Collectors.toUnmodifiableSet());
    }

    public Set<PermissionResource> getPermissions() {
        return permissions;
    }

    public Role getRole() {
        var result = new Role();
        result.setName(this.name());
        result.setPermissions(
                this.getPermissions().stream()
                        .map(p -> new Permission(p.authority()))
                        .collect(Collectors.toSet())
        );
        return result;
    }
}