package org.bshg.librarysystem.webservice.user.admin.employee;

import org.bshg.librarysystem.entity.core.user.admin.Employee;
import org.bshg.librarysystem.services.user.admin.employee.EmployeeService;
import org.bshg.librarysystem.sprocess.user.admin.employee.create.CreateEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.delete.DeleteEmployeeProcess;
import org.bshg.librarysystem.sprocess.user.admin.employee.update.UpdateEmployeeProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestApi {
    protected EmployeeService service;
    protected EmployeeConverter converter;
    protected CreateEmployeeProcess createProcess;
    protected UpdateEmployeeProcess updateProcess;
    protected DeleteEmployeeProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        Employee item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        EmployeeDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        List<Employee> all = service.findAll();
        List<EmployeeDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<EmployeeDto>> findAllOptimized() {
        List<Employee> all = service.findAllOptimized();
        List<EmployeeDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto dto) {
        converter.init(true);
        Employee item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<EmployeeDto>> save(@RequestBody List<EmployeeDto> dtos) {
        converter.init(true);
        List<Employee> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto dto) {
        converter.init(true);
        Employee item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<EmployeeDto>> update(@RequestBody List<EmployeeDto> dtos) {
        converter.init(true);
        List<Employee> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<EmployeeDto> delete(@RequestBody EmployeeDto dto) {
        converter.init(false);
        Employee item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<EmployeeDto>> delete(@RequestBody List<EmployeeDto> dtos) {
        converter.init(false);
        List<Employee> items = converter.toItem(dtos);
        deleteProcess.run(items);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        deleteProcess.run(id);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/ids")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
        deleteProcess.runByIds(ids);
        return ResponseEntity.ok(ids);
    }

    @DeleteMapping("/address/id/{id}")
    public ResponseEntity<Long> deleteByAddressId(@PathVariable Long id) {
        service.deleteByAddressId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/address/id/{id}")
    public ResponseEntity<EmployeeDto> findByAddressId(@PathVariable Long id) {
        Employee item = service.findByAddressId(id);
        EmployeeDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }
}