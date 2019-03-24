package com.nolik.reactive.twitter;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TwitterRepository extends ReactiveMongoRepository<Twit, String> {
    Flux<Twit> findAllByUserName(String strings);
}
