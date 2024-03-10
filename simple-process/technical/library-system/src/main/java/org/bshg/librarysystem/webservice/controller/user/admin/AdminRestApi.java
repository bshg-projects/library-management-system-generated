package org.bshg.librarysystem.webservice.controller.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.CreateAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.DeleteAdminProcess;
import org.bshg.librarysystem.sprocess.user.admin.admin.facade.UpdateAdminProcess;
import org.bshg.librarysystem.webservice.converter.user.admin.AdminConverter;
import org.bshg.librarysystem.webservice.dto.user.admin.AdminDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestApi {
    protected AdminService service;
    protected AdminConverter converter;
    protected CreateAdminProcess createProcess;
    protected UpdateAdminProcess updateProcess;
    protected DeleteAdminProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<AdminDto> findById(@PathVariable Long id) {
        Admin item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        AdminDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> findAll() {
        List<Admin> all = service.findAll();
        List<AdminDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<AdminDto>> findAllOptimized() {
        List<Admin> all = service.findAllOptimized();
        List<AdminDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<AdminDto> save(@RequestBody AdminDto dto) {
        converter.init(true);
        Admin item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<AdminDto>> save(@RequestBody List<AdminDto> dtos) {
        converter.init(true);
        List<Admin> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) {
        converter.init(true);
        Admin item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<AdminDto>> update(@RequestBody List<AdminDto> dtos) {
        converter.init(true);
        List<Admin> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<AdminDto> delete(@RequestBody AdminDto dto) {
        converter.init(false);
        Admin item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<AdminDto>> delete(@RequestBody List<AdminDto> dtos) {
        converter.init(false);
        List<Admin> items = converter.toItem(dtos);
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
}