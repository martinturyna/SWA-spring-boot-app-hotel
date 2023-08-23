package swa.hotel.service.integration.hotel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "hotel.hotel-app")
@Data
public class HotelConfigurationProperties {

    private String bookingUrl;
    private String hotelUrl;
    private String port;

}
