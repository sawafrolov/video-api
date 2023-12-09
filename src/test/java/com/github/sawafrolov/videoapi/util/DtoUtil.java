package com.github.sawafrolov.videoapi.util;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamUrlType;

import java.util.List;

public class DtoUtil {

    public static List<VideoCameraDto> apiData() {
        VideoCameraDto videoCameraDto1 = VideoCameraDto
                .builder()
                .id(1L)
                .sourceDataUrl("https://run.mocky.io/v3/e417b132-12ff-434d-a2c2-f81e6ddc1c6c")
                .tokenDataUrl("https://run.mocky.io/v3/fc0b6f75-b911-4b0a-9a1d-dc2379a6ef1c")
                .build();

        VideoCameraDto videoCameraDto2 = VideoCameraDto
                .builder()
                .id(2L)
                .sourceDataUrl("https://run.mocky.io/v3/86da6879-1444-4c92-818c-77b55d9c7864")
                .tokenDataUrl("https://run.mocky.io/v3/8b3babb6-c354-4874-a878-68d883c8425d")
                .build();

        VideoCameraDto videoCameraDto3 = VideoCameraDto
                .builder()
                .id(3L)
                .sourceDataUrl("https://run.mocky.io/v3/64ab5cc8-1f47-4ac5-a621-90d4410f7db7")
                .tokenDataUrl("https://run.mocky.io/v3/1ea436bd-1d3f-423c-9373-19e7d825dcd7")
                .build();

        VideoCameraDto videoCameraDto20 = VideoCameraDto
                .builder()
                .id(20L)
                .sourceDataUrl("https://run.mocky.io/v3/e8eee697-3018-4b2b-8b05-d00ab6b545c2")
                .tokenDataUrl("https://run.mocky.io/v3/e2d29bba-4315-453b-b270-e668b2a67af1")
                .build();

        return List.of(
                videoCameraDto1,
                videoCameraDto2,
                videoCameraDto3,
                videoCameraDto20
        );
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
