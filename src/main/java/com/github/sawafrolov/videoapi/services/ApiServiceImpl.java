package com.github.sawafrolov.videoapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    @Override
    public <T> Optional<T> retrieveObject(String url, Class<T> dtoClass) {
        T result = restTemplate.getForObject(url, dtoClass);
        return Optional.ofNullable(result);
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
