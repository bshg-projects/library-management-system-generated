package org.bshg.librarysystem.employee.sprocess.delete;

import org.bshg.librarysystem.address.Address;
import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.utils.sprocess.facade.IDeleteProcess;

public interface DeleteEmployeeProcess extends IDeleteProcess<Employee> {
    void deleteByAddress(Address address);
}