package org.bshg.librarysystem.webservice.controller.user;

import org.bshg.librarysystem.entity.core.user.Client;
import org.bshg.librarysystem.services.facade.user.ClientService;
import org.bshg.librarysystem.sprocess.user.client.facade.CreateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.UpdateClientProcess;
import org.bshg.librarysystem.sprocess.user.client.facade.DeleteClientProcess;
import org.bshg.librarysystem.webservice.converter.user.ClientConverter;
import org.bshg.librarysystem.webservice.dto.user.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestApi {
    protected ClientService service;
    protected ClientConverter converter;
    protected CreateClientProcess createProcess;
    protected UpdateClientProcess updateProcess;
    protected DeleteClientProcess deleteProcess;

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        Client item = service.findById(id);
        if (item == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        converter.init(true);
        ClientDto dto = converter.toDto(item);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        List<Client> all = service.findAll();
        List<ClientDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/optimized")
    public ResponseEntity<List<ClientDto>> findAllOptimized() {
        List<Client> all = service.findAllOptimized();
        List<ClientDto> dtos = converter.toDto(all);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto) {
        converter.init(true);
        Client item = converter.toItem(dto);
        item = createProcess.run(item);
        return new ResponseEntity<>(converter.toDto(item), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<ClientDto>> save(@RequestBody List<ClientDto> dtos) {
        converter.init(true);
        List<Client> items = converter.toItem(dtos);
        items = createProcess.run(items);
        return new ResponseEntity<>(converter.toDto(items), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto) {
        converter.init(true);
        Client item = converter.toItem(dto);
        item = updateProcess.run(item);
        return ResponseEntity.ok(converter.toDto(item));
    }

    @PutMapping("/all")
    public ResponseEntity<List<ClientDto>> update(@RequestBody List<ClientDto> dtos) {
        converter.init(true);
        List<Client> items = converter.toItem(dtos);
        items = updateProcess.run(items);
        return ResponseEntity.ok(converter.toDto(items));
    }

    @DeleteMapping
    public ResponseEntity<ClientDto> delete(@RequestBody ClientDto dto) {
        converter.init(false);
        Client item = converter.toItem(dto);
        deleteProcess.run(item);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/all")
    public ResponseEntity<List<ClientDto>> delete(@RequestBody List<ClientDto> dtos) {
        converter.init(false);
        List<Client> items = converter.toItem(dtos);
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