package com.github.sawafrolov.videoapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO для получения данных о видеокамерах
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
