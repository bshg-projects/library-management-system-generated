package org.bshg.librarysystem.webservice.controller.user.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;
import org.bshg.librarysystem.services.facade.user.admin.AdminService;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.bshg.librarysystem.webservice.converter.user.admin.AdminConverter;
import org.bshg.librarysystem.webservice.dto.user.admin.AdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminRestApi extends AbstractRestApi<Admin, AdminDto, AdminService, AdminConverter> {
    public AdminRestApi(AdminService service, AdminConverter converter) {
        super(service, converter);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<AdminDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AdminDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<AdminDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<AdminDto> save(@RequestBody AdminDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<AdminDto>> save(@RequestBody List<AdminDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<AdminDto>> update(@RequestBody List<AdminDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<AdminDto> delete(@RequestBody AdminDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<AdminDto>> delete(@RequestBody List<AdminDto> dtos) {
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
}