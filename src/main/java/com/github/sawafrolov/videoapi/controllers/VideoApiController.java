package com.github.sawafrolov.videoapi.controllers;

import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import com.github.sawafrolov.videoapi.services.VideoCameraInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/v1/video-camera-info")
@RequiredArgsConstructor
public class VideoApiController {

    private final VideoCameraInfoService videoCameraInfoService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Flux<VideoCameraInfoDto> collectVideoCameraInfo() {
        return videoCameraInfoService.collectVideoCameraInfo();
    }
}
