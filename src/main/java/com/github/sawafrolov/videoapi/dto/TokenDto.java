package com.github.sawafrolov.videoapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO для получения токенов безопасности
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class TokenDto {

    /**
     * Токен безопасности
     */
    private String value;

    /**
     * Время жизни токена
     */
    private Long ttl;
}
