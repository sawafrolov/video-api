package com.github.sawafrolov.videoapi.services;

import reactor.core.publisher.Flux;

import java.util.Optional;

public interface ApiService {

    <T> Optional<T> retrieveObject(String url, Class<T> dtoClass);

    <T> Flux<T> retrieveFlux(String url, Class<T> dtoClass);
}
