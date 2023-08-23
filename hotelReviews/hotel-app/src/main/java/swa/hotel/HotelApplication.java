package swa.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import swa.hotel.service.integration.hotel.config.HotelConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(HotelConfigurationProperties.class)
public class HotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApplication.class, args);
    }

}
