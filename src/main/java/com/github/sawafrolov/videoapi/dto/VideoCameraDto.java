package com.github.sawafrolov.videoapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO для получения данных о видеокамерах
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class VideoCameraDto {

    /**
     * id видеокамеры
     */
    private Long id;

    /**
     * Ссылка для получения данных видеопотока
     */
    private String sourceDataUrl;

    /**
     * Ссылка для получения токенов безопасности видеокамеры
     */
    private String tokenDataUrl;
}
