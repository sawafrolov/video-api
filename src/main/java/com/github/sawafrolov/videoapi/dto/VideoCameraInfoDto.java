package com.github.sawafrolov.videoapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO для отправки агрегированной информации о видеокамере
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class VideoCameraInfoDto {

    /**
     * id видеокамеры
     */
    private Long id;

    /**
     * Тип ссылки на видеопоток
     */
    private VideoStreamUrlType urlType;

    /**
     * Ссылка на видеопоток
     */
    private String videoUrl;

    /**
     * Токен безопасности
     */
    private String value;

    /**
     * Время жизни токена
     */
    private Long ttl;
}
