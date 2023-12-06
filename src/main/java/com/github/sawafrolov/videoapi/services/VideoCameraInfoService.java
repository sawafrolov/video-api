package com.github.sawafrolov.videoapi.services;

import com.github.sawafrolov.videoapi.dto.VideoCameraInfoDto;
import reactor.core.publisher.Flux;

public interface VideoCameraInfoService {

    Flux<VideoCameraInfoDto> collectVideoCameraInfo();
}
