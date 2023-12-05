package com.github.sawafrolov.videoapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO для получения данных о видеопотоке
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
