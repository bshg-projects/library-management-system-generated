package org.bshg.librarysystem.services.facade.user;
import org.bshg.librarysystem.entity.core.user.Staff;
import java.util.List;
public interface StaffService {
Staff findById(Long id);
List<Staff> findAllOptimized();
List<Staff> findAll();
Staff create(Staff item);
Staff edit(Staff item);
void deleteById(Long id);
void delete(Staff item);
void delete(List<Staff> items);
void deleteByIdIn(List<Long> ids);
}