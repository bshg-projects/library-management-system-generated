package org.bshg.librarysystem.loan.webservice;

import org.bshg.librarysystem.loan.Loan;
import org.bshg.librarysystem.loan.services.LoanService;
import org.bshg.librarysystem.utils.webservice.restapi.AbstractRestApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanRestApi extends AbstractRestApi<Loan, LoanDto, LoanService, LoanConverter> {
    public LoanRestApi(LoanService service, LoanConverter converter) {
        super(service, converter);
    }

    @Override
    @GetMapping("/id/{id}")
    public ResponseEntity<LoanDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LoanDto>> findAll() {
        return super.findAll();
    }

    @Override
    @GetMapping("/optimized")
    public ResponseEntity<List<LoanDto>> findAllOptimized() {
        return super.findAllOptimized();
    }

    @Override
    @PostMapping
    public ResponseEntity<LoanDto> save(@RequestBody LoanDto dto) {
        return super.save(dto);
    }

    @Override
    @PostMapping("/all")
    public ResponseEntity<List<LoanDto>> save(@RequestBody List<LoanDto> dtos) {
        return super.save(dtos);
    }

    @Override
    @PutMapping()
    public ResponseEntity<LoanDto> update(@RequestBody LoanDto dto) {
        return super.update(dto);
    }

    @Override
    @PutMapping("/all")
    public ResponseEntity<List<LoanDto>> update(@RequestBody List<LoanDto> dtos) {
        return super.update(dtos);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<LoanDto> delete(@RequestBody LoanDto dto) {
        return super.delete(dto);
    }

    @Override
    @DeleteMapping("/all")
    public ResponseEntity<List<LoanDto>> delete(@RequestBody List<LoanDto> dtos) {
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

    @DeleteMapping("/book/id/{id}")
    public ResponseEntity<Long> deleteByBookId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByBookId);
    }

    @GetMapping("/book/id/{id}")
    public ResponseEntity<LoanDto> findByBookId(@PathVariable Long id) {
        return super.findByChildId(id, service::findByBookId);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByClientId);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<LoanDto>> findByClientId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByClientId);
    }

    @DeleteMapping("/employee/id/{id}")
    public ResponseEntity<Long> deleteByEmployeeId(@PathVariable Long id) {
        return super.deleteProcess(id, service::deleteByEmployeeId);
    }

    @GetMapping("/employee/id/{id}")
    public ResponseEntity<List<LoanDto>> findByEmployeeId(@PathVariable Long id) {
        return super.findListByChildId(id, service::findByEmployeeId);
    }
}