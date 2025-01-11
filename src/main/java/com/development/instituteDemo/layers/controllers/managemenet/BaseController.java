package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
abstract class BaseController<TDTO, ID> {
    protected final BaseService<TDTO, ID> baseService;

    public BaseController(BaseService<TDTO, ID> baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public ResponseEntity<TDTO> create(@RequestBody TDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(baseService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TDTO> getById(@PathVariable ID id) {
        return ResponseEntity.of(baseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TDTO>> getAll() {
        return ResponseEntity.ok(baseService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TDTO> update(@PathVariable ID id, @RequestBody TDTO dto) {
        return ResponseEntity.ok(baseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        baseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }}
