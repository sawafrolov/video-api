package com.github.sawafrolov.videoapi.test.apiservice;

import com.github.sawafrolov.videoapi.dto.VideoCameraDto;
import com.github.sawafrolov.videoapi.services.ApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RetrieveDataTest {

    @Value("${video-api.api-service-test.incorrect-urls.video-api-url}")
    private String incorrectApiUrl;

    @Autowired
    private ApiService apiService;

    @Test
    @DisplayName("Check retrieve json array from API with null API URL")
    public void testRetrieveFluxUrlNull() {
        apiService
                .retrieveData(null, VideoCameraDto.class)
                .map(Object::hashCode)
                .subscribe(System.out::println);
    }

    @Test
    @DisplayName("Check retrieve json array from API with incorrect API URL")
    public void testRetrieveFluxUrlIncorrect() {
        apiService
                .retrieveData(incorrectApiUrl, VideoCameraDto.class)
                .map(Object::hashCode)
                .subscribe(System.out::println);
    }
}
