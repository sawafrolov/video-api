package com.github.sawafrolov.videoapi.test.apiservice;

import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.services.ApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.sawafrolov.videoapi.util.DtoUtil.apiData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RetrieveDataTest {

    @Value("${video-api.api-service-test.incorrect-urls.video-api-url}")
    private String incorrectApiUrl;

    @Value("${video-api.api-service-test.video-api-url}")
    private String apiUrl;

    @Autowired
    private ApiService apiService;

    @Test
    @DisplayName("Check retrieve json array from API with null API URL")
    public void testRetrieveDataUrlNull() {
        apiService
                .retrieveData(null, VideoCameraDto.class)
                .map(Object::hashCode)
                .subscribe(System.out::println);
    }

    @Test
    @DisplayName("Check retrieve json array from API with incorrect API URL")
    public void testRetrieveDataUrlIncorrect() {
        apiService
                .retrieveData(incorrectApiUrl, VideoCameraDto.class)
                .map(Object::hashCode)
                .subscribe(System.out::println);
    }

    @Test
    @DisplayName("Check retrieve json array from API")
    public void testRetrieveData() {
        apiService
                .retrieveData(apiUrl, VideoCameraDto.class)
                .collectList()
                .subscribe(apiData -> assertEquals(apiData, apiData()));
    }
}
