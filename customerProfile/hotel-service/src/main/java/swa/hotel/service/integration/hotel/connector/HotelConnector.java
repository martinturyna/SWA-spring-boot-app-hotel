package swa.hotel.service.integration.hotel.connector;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetHotelResponse;
import swa.hotel.service.integration.hotel.config.HotelConfigurationProperties;

@Component
@RequiredArgsConstructor
public class HotelConnector {

    private final RestTemplate restTemplate;

    private final HotelConfigurationProperties hotelConfigurationProperties;

    @Value("${server.address}")
    private String serverAddress;

    @Nullable
    public GetBookingsResponse getBookings(String customerId) {

        var uri = UriComponentsBuilder.fromUriString(hotelConfigurationProperties.getBookingUrl())
                .port(hotelConfigurationProperties.getPort())
                .scheme("http")
                .host(serverAddress)
                .queryParam("customerId", customerId)
                .build()
                .toUri();

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, GetBookingsResponse.class);

        if (responseEntity == null
                || responseEntity.getBody() == null) {

            return null;
        }

        return responseEntity.getBody();
    }

    @Nullable
    public GetHotelResponse getHotel(String hotelId) {

        var uri = UriComponentsBuilder.fromUriString(hotelConfigurationProperties.getHotelUrl())
                .port(hotelConfigurationProperties.getPort())
                .scheme("http")
                .host(serverAddress)
                .pathSegment(hotelId)
                .build()
                .toUri();

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, GetHotelResponse.class);

        if (responseEntity == null
                || responseEntity.getBody() == null) {

            return null;
        }

        return responseEntity.getBody();
    }

}
