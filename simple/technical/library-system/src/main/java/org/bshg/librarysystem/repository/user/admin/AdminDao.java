package org.bshg.librarysystem.repository.user.admin;
import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface AdminDao extends JpaRepository<Admin, Long> {
int deleteByIdIn(List<Long> ids);
}