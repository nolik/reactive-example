package com.nolik.reactive.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class TwitHandler {
    private final TwitterRepository twitterRepository;

    Mono<ServerResponse> listOfTwits(ServerRequest request) {
        Flux<Twit> twits = twitterRepository.findAll();
        return ok().contentType(TEXT_EVENT_STREAM).body(twits, Twit.class);
    }

    Mono<ServerResponse> listOfTwitsByUser(ServerRequest request) {
        Flux<Twit> twits = twitterRepository.findAllByUserName(request.pathVariable("username"));
        return ok().contentType(TEXT_EVENT_STREAM).body(twits, Twit.class);
    }
}
