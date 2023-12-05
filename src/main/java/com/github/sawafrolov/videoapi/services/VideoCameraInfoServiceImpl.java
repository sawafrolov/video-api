package com.github.sawafrolov.videoapi.services;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import com.github.sawafrolov.videoapi.mappers.VideoCameraInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class VideoCameraInfoServiceImpl implements VideoCameraInfoService {

    private final ApiService apiService;

    private final VideoCameraInfoMapper videoCameraInfoMapper;

    @Override
    public Flux<VideoCameraInfoDto> collectVideoCameraInfo(String url) {
        return apiService
                .retrieveFlux(url, VideoCameraDto.class)
                .map(this::collectInfo);
    }

    private VideoCameraInfoDto collectInfo(VideoCameraDto videoCameraDto) {
        VideoStreamDto videoStreamDto = apiService
                .retrieveMono(videoCameraDto.getSourceDataUrl(), VideoStreamDto.class)
                .blockOptional()
                .orElseThrow();

        TokenDto tokenDto = apiService
                .retrieveMono(videoCameraDto.getTokenDataUrl(), TokenDto.class)
                .blockOptional()
                .orElseThrow();

        return videoCameraInfoMapper.mapToInfoDto(videoCameraDto, videoStreamDto, tokenDto);
    }
}
