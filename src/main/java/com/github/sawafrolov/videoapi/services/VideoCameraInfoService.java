package com.github.sawafrolov.videoapi.services;

import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import reactor.core.publisher.Flux;

/**
 * Сервис для получения данных о видеокамерах от API по ссылке
 */
public interface VideoCameraInfoService {

    /**
     * Получает данные о видеокамерах от API по ссылке
     * @param url Ссылка на API
     * @return Данные о видеокамерах
     */
    Flux<VideoCameraInfoDto> collectVideoCameraInfo(String url);
}
