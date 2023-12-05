package com.github.sawafrolov.videoapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final WebClient webClient;

    @Override
    public <T> Mono<T> retrieveMono(String url, Class<T> dtoClass) {
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(dtoClass);
    }

    @Override
    public <T> Flux<T> retrieveFlux(String url, Class<T> dtoClass) {
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(dtoClass);
    }
}
