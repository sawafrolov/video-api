package com.github.sawafrolov.videoapi.util;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamUrlType;
import reactor.core.publisher.Flux;

public class DtoUtil {

    public static Flux<VideoCameraDto> apiResult() {
        return null;
    }

    public static VideoStreamDto videoStreamDtoId2() {
        return VideoStreamDto
                .builder()
                .urlType(VideoStreamUrlType.ARCHIVE)
                .videoUrl("rtsp://127.0.0.1/2")
                .build();
    }

    public static VideoStreamDto videoStreamDtoId3() {
        return VideoStreamDto
                .builder()
                .urlType(VideoStreamUrlType.ARCHIVE)
                .videoUrl("rtsp://127.0.0.1/3")
                .build();
    }

    public static TokenDto tokenDtoId2() {
        return TokenDto
                .builder()
                .value("fa4b5b22-249b-11e9-ab14-d663bd873d93")
                .ttl(60L)
                .build();
    }

    public static TokenDto tokenDtoId3() {
        return TokenDto
                .builder()
                .value("fa4b5d52-249b-11e9-ab14-d663bd873d93")
                .ttl(120L)
                .build();
    }
}
