package org.bshg.librarysystem.staff;
import org.bshg.librarysystem.staff.Staff;
import org.bshg.librarysystem.utils.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface StaffDao extends Repository<Staff, Long> {
}