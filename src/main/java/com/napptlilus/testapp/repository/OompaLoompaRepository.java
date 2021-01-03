package com.napptlilus.testapp.repository;

import com.napptlilus.testapp.model.OompaLoompa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OompaLoompaRepository extends ReactiveSortingRepository<OompaLoompa, String> {

    Flux<OompaLoompa>  findByIdNotNull(Pageable pageable);
}
