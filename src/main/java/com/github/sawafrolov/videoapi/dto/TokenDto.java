package com.github.sawafrolov.videoapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DTO для получения токенов безопасности
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
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
