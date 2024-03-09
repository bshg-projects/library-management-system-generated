package org.bshg.librarysystem.staff;
import org.bshg.librarysystem.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface StaffDao extends JpaRepository<Staff, Long> {
int deleteByIdIn(List<Long> ids);
}