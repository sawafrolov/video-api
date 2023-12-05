package com.github.sawafrolov.videoapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO для отправки агрегированной информации о видеокамере
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
