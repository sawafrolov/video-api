package com.github.sawafrolov.videoapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO для получения данных о видеопотоке
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class VideoStreamDto {

    /**
     * Тип ссылки на видеопоток
     */
    private VideoStreamUrlType urlType;

    /**
     * Ссылка на видеопоток
     */
    private String videoUrl;
}
