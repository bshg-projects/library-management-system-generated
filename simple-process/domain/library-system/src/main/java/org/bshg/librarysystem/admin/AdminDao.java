package org.bshg.librarysystem.admin;
import org.bshg.librarysystem.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AdminDao extends JpaRepository<Admin, Long> {
int deleteByIdIn(List<Long> ids);
}