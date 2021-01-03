package com.napptlilus.testapp.service;

import com.napptlilus.testapp.model.OompaLoompa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OompaLoompaService {

    Mono<OompaLoompa> findById (String id);

    Flux<OompaLoompa> findAll(int pageNumber, int size);

    Mono<OompaLoompa> create(OompaLoompa oompaLoompa) ;

    Mono<OompaLoompa> update(OompaLoompa oompaLoompa) ;
}
