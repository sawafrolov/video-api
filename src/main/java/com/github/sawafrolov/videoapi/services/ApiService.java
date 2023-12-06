package com.github.sawafrolov.videoapi.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {

    <T> Mono<T> retrieveMono(String url, Class<T> dtoClass);

    <T> Flux<T> retrieveFlux(String url, Class<T> dtoClass);
}
