package com.napptlilus.testapp.controller;

import com.napptlilus.testapp.dto.OompaLoompaDTO;
import com.napptlilus.testapp.dto.OompaLoompaQueryResponseDTO;
import com.napptlilus.testapp.exception.NotFoundException;
import com.napptlilus.testapp.model.OompaLoompa;
import com.napptlilus.testapp.service.OompaLoompaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/oompaloompa")
public class OompaLoompaController {

    private OompaLoompaService oompaLoompaService;
    private ModelMapper modelMapper;

    public OompaLoompaController(OompaLoompaService oompaLoompaService, ModelMapper modelMapper) {
        this.oompaLoompaService = oompaLoompaService;
        this.modelMapper = modelMapper;
    }

    /**
     * creates OompaLoompa
     *
     * @param oompaLoompaDTO
     * @return
     */
    @PostMapping
    public Mono<OompaLoompaDTO> create(@RequestBody OompaLoompaDTO oompaLoompaDTO) {
        return oompaLoompaService.create(toEntity(oompaLoompaDTO))
                .map(item -> toDTO(item, OompaLoompaDTO.class));
    }

    @PutMapping
    public Mono<ResponseEntity<OompaLoompaDTO>> update(@RequestBody OompaLoompaDTO oompaLoompaDTO) {
        return oompaLoompaService.update(toEntity(oompaLoompaDTO))
                .map(item -> this.toDTO(item, OompaLoompaDTO.class))
                .map(ResponseEntity::ok)
                .onErrorReturn(NotFoundException.class, ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/{id}")
    public Mono<OompaLoompa> findById(@PathVariable String id) {
        return oompaLoompaService.findById(id);
    }

    @GetMapping(path = "/findAll")
    public Flux<OompaLoompaQueryResponseDTO> findAll(@RequestParam(defaultValue = "0") int pageNumber,
                                                                     @RequestParam(defaultValue = "10") int size) {
        return oompaLoompaService.findAll(pageNumber, size)
                .map(item -> toDTO(item, OompaLoompaQueryResponseDTO.class));
    }

    private <T> T toDTO(OompaLoompa oompaLoompa, Class<T> classType) {
        return modelMapper.map(oompaLoompa, classType);
    }

    private OompaLoompa toEntity(OompaLoompaDTO oompaLoompaDTO) {
        return modelMapper.map(oompaLoompaDTO, OompaLoompa.class);
    }
}