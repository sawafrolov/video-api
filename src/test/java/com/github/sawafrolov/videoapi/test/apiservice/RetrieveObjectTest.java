package com.github.sawafrolov.videoapi.test.apiservice;

import com.github.sawafrolov.videoapi.dto.TokenDto;
import com.github.sawafrolov.videoapi.dto.VideoStreamDto;
import com.github.sawafrolov.videoapi.services.ApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

import static com.github.sawafrolov.videoapi.util.DtoUtil.tokenDtoId2;
import static com.github.sawafrolov.videoapi.util.DtoUtil.tokenDtoId3;
import static com.github.sawafrolov.videoapi.util.DtoUtil.videoStreamDtoId2;
import static com.github.sawafrolov.videoapi.util.DtoUtil.videoStreamDtoId3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RetrieveObjectTest {

    @Value("${video-api.api-service-test.incorrect-urls.source-data-url}")
    private String incorrectObjectUrl;

    @Value("${video-api.api-service-test.source-data-url.id2}")
    private String sourceDataUrl2;

    @Value("${video-api.api-service-test.source-data-url.id3}")
    private String sourceDataUrl3;

    @Value("${video-api.api-service-test.token-data-url.id2}")
    private String tokenDataUrl2;

    @Value("${video-api.api-service-test.token-data-url.id3}")
    private String tokenDataUrl3;

    @Autowired
    private ApiService apiService;

    @Test
    @DisplayName("Check retrieve json object from API with null API URL")
    public void testRetrieveObjectUrlNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> apiService.retrieveObject(null, VideoStreamDto.class)
        );
    }

    @Test
    @DisplayName("Check retrieve json object from API with incorrect API URL")
    public void testRetrieveObjectUrlIncorrect() {
        assertThrows(
                HttpClientErrorException.NotFound.class,
                () -> apiService.retrieveObject(incorrectObjectUrl, VideoStreamDto.class)
        );
    }

    @Test
    @DisplayName("Check retrieve VideoStreamDto from API with API URL for id=2")
    public void testRetrieveVideoStreamDtoId2() {
        Optional<VideoStreamDto> videoStreamDtoOptional = apiService.retrieveObject(sourceDataUrl2, VideoStreamDto.class);
        assertTrue(videoStreamDtoOptional.isPresent());
        videoStreamDtoOptional.ifPresent(videoStreamDto -> assertEquals(videoStreamDto, videoStreamDtoId2()));
    }

    @Test
    @DisplayName("Check retrieve VideoStreamDto from API with API URL for id=3")
    public void testRetrieveVideoStreamDtoId3() {
        Optional<VideoStreamDto> videoStreamDtoOptional = apiService.retrieveObject(sourceDataUrl3, VideoStreamDto.class);
        assertTrue(videoStreamDtoOptional.isPresent());
        videoStreamDtoOptional.ifPresent(videoStreamDto -> assertEquals(videoStreamDto, videoStreamDtoId3()));
    }

    @Test
    @DisplayName("Check retrieve TokenDto from API with API URL for id=2")
    public void testRetrieveTokenDtoId2() {
        Optional<TokenDto> tokenDtoOptional = apiService.retrieveObject(tokenDataUrl2, TokenDto.class);
        assertTrue(tokenDtoOptional.isPresent());
        tokenDtoOptional.ifPresent(tokenDto -> assertEquals(tokenDto, tokenDtoId2()));
    }

    @Test
    @DisplayName("Check retrieve TokenDto from API with API URL for id=3")
    public void testRetrieveTokenDtoId3() {
        Optional<TokenDto> tokenDtoOptional = apiService.retrieveObject(tokenDataUrl3, TokenDto.class);
        assertTrue(tokenDtoOptional.isPresent());
        tokenDtoOptional.ifPresent(tokenDto -> assertEquals(tokenDto, tokenDtoId3()));
    }
}
