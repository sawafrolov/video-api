package com.github.sawafrolov.videoapi.services;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoCameraInfoServiceImpl implements VideoCameraInfoService {

    @Value("${video-api.protocol}")
    private String protocol;

    @Value("${video-api.source-url}")
    private String videoApiUrl;

    @Value("${video-api.api-version}")
    private int videoApiVersion;

    @Value("${video-api.owner-id}")
    private UUID videoApiOwnerId;

    private final ApiService apiService;

    @Override
    public Flux<VideoCameraInfoDto> collectVideoCameraInfo() {
        return apiService
                .retrieveFlux(createApiUrl(), VideoCameraDto.class)
                .map(this::collectInfo);
    }

    private String createApiUrl() {
        String path = String.format("v%d/%s", videoApiVersion, videoApiOwnerId);

        return UriComponentsBuilder
                .newInstance()
                .scheme(protocol)
                .host(videoApiUrl)
                .path(path)
                .build()
                .toUri()
                .toString();
    }

    private VideoCameraInfoDto collectInfo(VideoCameraDto videoCameraDto) {
        VideoCameraInfoDto videoCameraInfoDto = new VideoCameraInfoDto();
        videoCameraInfoDto.setId(videoCameraDto.getId());

        apiService
                .retrieveMono(videoCameraDto.getSourceDataUrl(), VideoStreamDto.class)
                .subscribe(videoStreamDto -> {
                    videoCameraInfoDto.setUrlType(videoStreamDto.getUrlType());
                    videoCameraInfoDto.setVideoUrl(videoStreamDto.getVideoUrl());
                });

        apiService
                .retrieveMono(videoCameraDto.getTokenDataUrl(), TokenDto.class)
                .subscribe(tokenDto -> {
                    videoCameraInfoDto.setValue(tokenDto.getValue());
                    videoCameraInfoDto.setTtl(tokenDto.getTtl());
                });

        return videoCameraInfoDto;
    }
}
