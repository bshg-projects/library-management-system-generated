package org.bshg.librarysystem.employeeassignment.webservice;

import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.sprocess.create.CreateEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.delete.DeleteEmployeeAssignmentProcess;
import org.bshg.librarysystem.employeeassignment.sprocess.update.UpdateEmployeeAssignmentProcess;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeassignment")
public class EmployeeAssignmentRestApi extends AbstractRestApi<
        EmployeeAssignment,
        EmployeeAssignmentDto,
        EmployeeAssignmentService,
        EmployeeAssignmentConverter,
        CreateEmployeeAssignmentProcess,
        UpdateEmployeeAssignmentProcess,
        DeleteEmployeeAssignmentProcess> {
    public EmployeeAssignmentRestApi(EmployeeAssignmentService service, EmployeeAssignmentConverter converter, CreateEmployeeAssignmentProcess createProcess, UpdateEmployeeAssignmentProcess updateProcess, DeleteEmployeeAssignmentProcess deleteProcess) {
        super(service, converter, createProcess, updateProcess, deleteProcess);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeAssignmentDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeAssignmentDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<EmployeeAssignmentDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<EmployeeAssignmentDto> save(@RequestBody EmployeeAssignmentDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> save(@RequestBody List<EmployeeAssignmentDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<EmployeeAssignmentDto> update(@RequestBody EmployeeAssignmentDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> update(@RequestBody List<EmployeeAssignmentDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<EmployeeAssignmentDto> delete(@RequestBody EmployeeAssignmentDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<EmployeeAssignmentDto>> delete(@RequestBody List<EmployeeAssignmentDto> dtos) {
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

    @DeleteMapping("/admin/id/{id}")
    public ResponseEntity<Long> deleteByAdminId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByAdminId);
    }

    @GetMapping("/admin/id/{id}")
    public ResponseEntity<List<EmployeeAssignmentDto>> findByAdminId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByAdminId);
    }

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByEmployeeId);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<EmployeeAssignmentDto>> findByEmployeeId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByEmployeeId);
    }
}