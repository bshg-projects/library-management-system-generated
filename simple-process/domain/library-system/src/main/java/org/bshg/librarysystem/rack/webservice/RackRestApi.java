package org.bshg.librarysystem.rack.webservice;

import org.bshg.librarysystem.rack.Rack;
import org.bshg.librarysystem.rack.services.RackService;
import org.bshg.librarysystem.rack.sprocess.create.CreateRackProcess;
import org.bshg.librarysystem.rack.sprocess.delete.DeleteRackProcess;
import org.bshg.librarysystem.rack.sprocess.update.UpdateRackProcess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rack")
public class RackRestApi {
    protected RackService service;
    protected RackConverter converter;
    protected CreateRackProcess createProcess;
    protected UpdateRackProcess updateProcess;
    protected DeleteRackProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<RackDto> findById(@PathVariable Long id) {
        Rack item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        RackDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<RackDto>> findAll() {
        List<Rack> all = service.findAll();
        List<RackDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<RackDto>> findAllOptimized() {
        List<Rack> all = service.findAllOptimized();
        List<RackDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<RackDto> save(@RequestBody RackDto dto) {
        converter.init(true);
        Rack item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<RackDto>> save(@RequestBody List<RackDto> dtos) {
        converter.init(true);
        List<Rack> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<RackDto> update(@RequestBody RackDto dto) {
        converter.init(true);
        Rack item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<RackDto>> update(@RequestBody List<RackDto> dtos) {
        converter.init(true);
        List<Rack> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<RackDto> delete(@RequestBody RackDto dto) {
        converter.init(false);
        Rack item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<RackDto>> delete(@RequestBody List<RackDto> dtos) {
        converter.init(false);
        List<Rack> items = converter.toItem(dtos);
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

    @DeleteMapping("/shelf/id/{id}")
    public ResponseEntity<Long> deleteByShelfId(@PathVariable Long id) {
        service.deleteByShelfId(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/shelf/id/{id}")
    public ResponseEntity<List<RackDto>> findByShelfId(@PathVariable Long id) {
        List<Rack> items = service.findByShelfId(id);
        List<RackDto> dtos = converter.toDto(items);
        return ResponseEntity.ok(dtos);
    }
}