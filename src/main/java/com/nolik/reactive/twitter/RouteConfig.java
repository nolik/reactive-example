package com.nolik.reactive.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@RequiredArgsConstructor
public class RouteConfig {
    private final TwitHandler twitHandler;

    @Bean
    RouterFunction<?> routes(){
        return RouterFunctions. route()
                .GET("/twits", accept(TEXT_EVENT_STREAM), twitHandler::listOfTwits)
                .GET("/twits/{id}", accept(TEXT_EVENT_STREAM), twitHandler::listOfTwitsByUser)
                .build();
    }
}

