package org.bshg.librarysystem.employeeassignment.webservice;

import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeassignment")
public class EmployeeAssignmentRestApi {
    protected EmployeeAssignmentService service;
    protected EmployeeAssignmentConverter converter;
    protected CreateEmployeeAssignmentProcess createProcess;
    protected UpdateEmployeeAssignmentProcess updateProcess;
    protected DeleteEmployeeAssignmentProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeAssignmentDto> findById(@PathVariable Long id) {
        EmployeeAssignment item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        EmployeeAssignmentDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeAssignmentDto>> findAll() {
        List<EmployeeAssignment> all = service.findAll();
        List<EmployeeAssignmentDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<EmployeeAssignmentDto>> findAllOptimized() {
        List<EmployeeAssignment> all = service.findAllOptimized();
        List<EmployeeAssignmentDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<EmployeeAssignmentDto> save(@RequestBody EmployeeAssignmentDto dto) {
        converter.init(true);
        EmployeeAssignment item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> save(@RequestBody List<EmployeeAssignmentDto> dtos) {
        converter.init(true);
        List<EmployeeAssignment> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<EmployeeAssignmentDto> update(@RequestBody EmployeeAssignmentDto dto) {
        converter.init(true);
        EmployeeAssignment item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> update(@RequestBody List<EmployeeAssignmentDto> dtos) {
        converter.init(true);
        List<EmployeeAssignment> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<EmployeeAssignmentDto> delete(@RequestBody EmployeeAssignmentDto dto) {
        converter.init(false);
        EmployeeAssignment item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> delete(@RequestBody List<EmployeeAssignmentDto> dtos) {
        converter.init(false);
        List<EmployeeAssignment> items = converter.toItem(dtos);
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

    @DeleteMapping("/admin/id/{id}")
    public ResponseEntity<Long> deleteByAdminId(@PathVariable Long id) {
        service.deleteByAdminId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/admin/id/{id}")
    public ResponseEntity<List<EmployeeAssignmentDto>> findByAdminId(@PathVariable Long id) {
        List<EmployeeAssignment> items = service.findByAdminId(id);
        List<EmployeeAssignmentDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        service.deleteByEmployeeId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<EmployeeAssignmentDto>> findByEmployeeId(@PathVariable Long id) {
        List<EmployeeAssignment> items = service.findByEmployeeId(id);
        List<EmployeeAssignmentDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}