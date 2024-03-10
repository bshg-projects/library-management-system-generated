package org.bshg.librarysystem.employee.webservice;

import org.bshg.librarysystem.employee.Employee;
import org.bshg.librarysystem.employee.services.EmployeeService;
import org.bshg.librarysystem.employee.sprocess.create.CreateEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.employee.sprocess.update.UpdateEmployeeProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestApi extends AbstractRestApi<
        Employee,
        EmployeeDto,
        EmployeeService,
        EmployeeConverter,
        CreateEmployeeProcess,
        UpdateEmployeeProcess,
        DeleteEmployeeProcess> {
    public EmployeeRestApi(EmployeeService service, EmployeeConverter converter, CreateEmployeeProcess createProcess, UpdateEmployeeProcess updateProcess, DeleteEmployeeProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<EmployeeDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<EmployeeDto>> save(@RequestBody List<EmployeeDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<EmployeeDto>> update(@RequestBody List<EmployeeDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<EmployeeDto> delete(@RequestBody EmployeeDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<EmployeeDto>> delete(@RequestBody List<EmployeeDto> dtos) {
        return super.delete(dtos);
    }

    @Override
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        return super.deleteById(id);
    }

    @Override
    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
        return super.deleteByIdIn(ids);
    }

    @DeleteMapping("/address/id/{id}")
    public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByAddressId);
    }

    @GetMapping("/address/id/{id}")
    public ResponseEntity<EmployeeDto> findByAddressId(@PathVariable Long id) {
        return super.findByChildId(id, service::findByAddressId);
    }
}