package com.github.sawafrolov.videoapi.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Сервис для получения данных от API с помощью Spring WebFlux
 */
public interface ApiService {

    /**
     * Получает объект заданного класса от API
     * и упаковывает его в Reactor Mono
     * @param url Ссылка на API
     * @param dtoClass Класс DTO для получения объекта
     * @return Reactor Mono, содержащий объект заданного класса
     * @param <T> Класс DTO для получения объекта
     */
    <T> Mono<T> retrieveMono(String url, Class<T> dtoClass);

    /**
     * Получает массив объектов заданного класса от API
     * и упаковывает его в Reactor Flux
     * @param url Ссылка на API
     * @param dtoClass Класс DTO для получения объекта
     * @return Reactor Flux, содержащий объекты заданного класса
     * @param <T> Класс DTO для получения объекта
     */
    <T> Flux<T> retrieveFlux(String url, Class<T> dtoClass);
}
