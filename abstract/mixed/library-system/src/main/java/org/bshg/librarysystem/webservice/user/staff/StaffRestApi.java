package org.bshg.librarysystem.webservice.user.staff;

import org.bshg.librarysystem.entity.core.user.Staff;
import org.bshg.librarysystem.services.user.staff.StaffService;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestApi extends AbstractRestApi<Staff, StaffDto, StaffService, StaffConverter> {
    public StaffRestApi(StaffService service, StaffConverter converter) {
        super(service, converter);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<StaffDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<StaffDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<StaffDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<StaffDto> save(@RequestBody StaffDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<StaffDto>> save(@RequestBody List<StaffDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<StaffDto> update(@RequestBody StaffDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<StaffDto>> update(@RequestBody List<StaffDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<StaffDto> delete(@RequestBody StaffDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<StaffDto>> delete(@RequestBody List<StaffDto> dtos) {
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