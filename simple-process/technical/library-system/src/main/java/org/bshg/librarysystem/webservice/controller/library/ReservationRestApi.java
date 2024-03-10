package org.bshg.librarysystem.webservice.controller.library;

import org.bshg.librarysystem.entity.core.library.Reservation;
import org.bshg.librarysystem.services.facade.library.ReservationService;
import org.bshg.librarysystem.sprocess.library.reservation.facade.CreateReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.DeleteReservationProcess;
import org.bshg.librarysystem.sprocess.library.reservation.facade.UpdateReservationProcess;
import org.bshg.librarysystem.webservice.converter.library.ReservationConverter;
import org.bshg.librarysystem.webservice.dto.library.ReservationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestApi {
    protected ReservationService service;
    protected ReservationConverter converter;
    protected CreateReservationProcess createProcess;
    protected UpdateReservationProcess updateProcess;
    protected DeleteReservationProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<ReservationDto> findById(@PathVariable Long id) {
        Reservation item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        ReservationDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> findAll() {
        List<Reservation> all = service.findAll();
        List<ReservationDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<ReservationDto>> findAllOptimized() {
        List<Reservation> all = service.findAllOptimized();
        List<ReservationDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<ReservationDto> save(@RequestBody ReservationDto dto) {
        converter.init(true);
        Reservation item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<ReservationDto>> save(@RequestBody List<ReservationDto> dtos) {
        converter.init(true);
        List<Reservation> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ReservationDto> update(@RequestBody ReservationDto dto) {
        converter.init(true);
        Reservation item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<ReservationDto>> update(@RequestBody List<ReservationDto> dtos) {
        converter.init(true);
        List<Reservation> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<ReservationDto> delete(@RequestBody ReservationDto dto) {
        converter.init(false);
        Reservation item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<ReservationDto>> delete(@RequestBody List<ReservationDto> dtos) {
        converter.init(false);
        List<Reservation> items = converter.toItem(dtos);
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

    @DeleteMapping("/book/id/{id}")
    public ResponseEntity<Long> deleteByBookId(@PathVariable Long id) {
        service.deleteByBookId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/book/id/{id}")
    public ResponseEntity<ReservationDto> findByBookId(@PathVariable Long id) {
        Reservation item = service.findByBookId(id);
        ReservationDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/client/id/{id}")
    public ResponseEntity<Long> deleteByClientId(@PathVariable Long id) {
        service.deleteByClientId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/client/id/{id}")
    public ResponseEntity<List<ReservationDto>> findByClientId(@PathVariable Long id) {
        List<Reservation> items = service.findByClientId(id);
        List<ReservationDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}