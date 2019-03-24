package com.nolik.reactive.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class Initializer implements ApplicationRunner {
    private final TwitterRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flux.interval(Duration.ofSeconds(5))
                .zipWithIterable(asList(
                new Twit(null, "Ihar", "sup"),
                new Twit(null, "Vasia", "Reactive rules?"),
                new Twit(null, "Ihar", "Reactive rules!!!"),
                new Twit(null, "Vasia", "Crappy js"),
                new Twit(null, "Ihar", "Reactive a!!!"),
                new Twit(null, "Ihar", "Reactive x!!!"),
                new Twit(null, "Ihar", "Reactive y!!!")))
                .map(Tuple2::getT2)
                .flatMap(userRepository::save)
                .thenMany(userRepository.findAll())
                .subscribe(System.out::println);
    }
}