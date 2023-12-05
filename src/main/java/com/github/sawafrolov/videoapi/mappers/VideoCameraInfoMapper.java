package com.github.sawafrolov.videoapi.mappers;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Преобразует 3 DTO с данными от API
 * в DTO для отправки данных в ответ на запрос
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoCameraInfoMapper {

    /**
     * Преобразует 3 DTO с данными от API
     * в DTO для отправки данных в ответ на запрос
     * @param videoCameraDto DTO с данными о видеокамере
     * @param videoStreamDto DTO с данными о видеопотоке
     * @param tokenDto DTO с токеном безопасности
     * @return DTO с полной информацией о видеокамере
     */
    VideoCameraInfoDto mapToInfoDto(VideoCameraDto videoCameraDto, VideoStreamDto videoStreamDto, TokenDto tokenDto);
}
