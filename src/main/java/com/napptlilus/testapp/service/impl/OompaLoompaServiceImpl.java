package com.napptlilus.testapp.service.impl;

import com.napptlilus.testapp.exception.NotFoundException;
import com.napptlilus.testapp.log.LogMe;
import com.napptlilus.testapp.model.OompaLoompa;
import com.napptlilus.testapp.repository.OompaLoompaRepository;
import com.napptlilus.testapp.service.OompaLoompaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OompaLoompaServiceImpl  implements  OompaLoompaService{

    OompaLoompaRepository oompaLoompaRepository;

    public OompaLoompaServiceImpl(OompaLoompaRepository oompaLoompaRepository) {
        this.oompaLoompaRepository = oompaLoompaRepository;
    }

    /**
     * creates OompaLoompa entity
     * @LogMe annotation adds INFO level log on execution
     * @param oompaLoompa
     */
    @LogMe("creating new Oompaloompa...")
    public Mono<OompaLoompa> create(OompaLoompa oompaLoompa) {
        return oompaLoompaRepository.save(oompaLoompa);
    }

    /**
     * updates OompaLoompa entity
     * @LogMe annotation adds INFO level log on execution
     * @param oompaLoompa
     */
    @Override
    @LogMe("Updating Oompaloompa...")
    public Mono<OompaLoompa> update(OompaLoompa oompaLoompa) {
        return oompaLoompaRepository.findById(oompaLoompa.getId())
                .flatMap(existingOompaLoompa -> {
                    BeanUtils.copyProperties(oompaLoompa, existingOompaLoompa);
                    return oompaLoompaRepository.save(oompaLoompa);
                })
                .switchIfEmpty(Mono.error(new NotFoundException("element not found")));
    }

    /**
     * find by Object id
     * @param id
     * @return
     */
    @Override
    public Mono<OompaLoompa> findById(String id) {
        return oompaLoompaRepository.findById(id);
    }

    /**
     * find all OompaLoompa with given page
     * @param pageNumber
     * @param size
     * @return
     */
    @Override
    public Flux<OompaLoompa> findAll(int pageNumber, int size) {
        Pageable page = PageRequest.of(pageNumber, size);
        return oompaLoompaRepository.findByIdNotNull(page);
    }

}
