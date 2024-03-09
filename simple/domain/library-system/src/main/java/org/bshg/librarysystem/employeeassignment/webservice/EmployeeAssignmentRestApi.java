package org.bshg.librarysystem.employeeassignment.webservice;
import org.bshg.librarysystem.employeeassignment.EmployeeAssignment;
import org.bshg.librarysystem.employeeassignment.services.EmployeeAssignmentService;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentConverter;
import org.bshg.librarysystem.employeeassignment.webservice.EmployeeAssignmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/employeeassignment")
public class EmployeeAssignmentRestApi {
@Autowired private EmployeeAssignmentService service;
@Autowired private EmployeeAssignmentConverter converter;
@GetMapping("/id/{id}")
public ResponseEntity<EmployeeAssignmentDto> findById(@PathVariable Long id) {
var result = service.findById(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping
public ResponseEntity<List<EmployeeAssignmentDto>> findAll() {
var result = service.findAll();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@GetMapping("/optimized")
public ResponseEntity<List<EmployeeAssignmentDto>> findAllOptimized() {
var result = service.findAllOptimized();
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping
public ResponseEntity<EmployeeAssignmentDto> save(@RequestBody EmployeeAssignmentDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PostMapping("/all")
public ResponseEntity<List<EmployeeAssignmentDto>> save(@RequestBody List<EmployeeAssignmentDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.create(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping()
public ResponseEntity<EmployeeAssignmentDto> update(@RequestBody EmployeeAssignmentDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@PutMapping("/all")
public ResponseEntity<List<EmployeeAssignmentDto>> update(@RequestBody List<EmployeeAssignmentDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
var result = service.update(item);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping
public ResponseEntity<EmployeeAssignmentDto> delete(@RequestBody EmployeeAssignmentDto dto) {
if (dto == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dto);
service.delete(item);
return ResponseEntity.ok(dto);
}
@DeleteMapping("/all")
public ResponseEntity<List<EmployeeAssignmentDto>> delete(@RequestBody List<EmployeeAssignmentDto> dtos) {
if (dtos == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
var item = converter.toItem(dtos);
service.delete(item);
return ResponseEntity.ok(dtos);
}
@DeleteMapping("/id/{id}")
public ResponseEntity<Long> deleteById(@PathVariable Long id) {
service.deleteById(id);
return ResponseEntity.ok(id);
}
@DeleteMapping("/ids")
public ResponseEntity<List<Long>> deleteByIdIn(@RequestParam("id") List<Long> ids) {
service.deleteByIdIn(ids);
return ResponseEntity.ok(ids);
}
@DeleteMapping("/admin/id/{id}")
public ResponseEntity<Long> deleteByAdminId(@PathVariable Long id){
service.deleteByAdminId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/admin/id/{id}")
public ResponseEntity<List<EmployeeAssignmentDto>> findByAdminId(@PathVariable Long id){
var result = service.findByAdminId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
@DeleteMapping("/employee/id/{id}")
public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id){
service.deleteByEmployeeId(id);
return ResponseEntity.ok(id);
}
@GetMapping("/employee/id/{id}")
public ResponseEntity<List<EmployeeAssignmentDto>> findByEmployeeId(@PathVariable Long id){
var result = service.findByEmployeeId(id);
var resultDto = converter.toDto(result);
return ResponseEntity.ok(resultDto);
}
}