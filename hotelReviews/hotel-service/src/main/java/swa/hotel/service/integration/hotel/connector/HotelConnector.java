package swa.hotel.service.integration.hotel.connector;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import swa.hotel.service.integration.hotel.api.GetBookingsResponse;
import swa.hotel.service.integration.hotel.api.GetRoomResponse;
import swa.hotel.service.integration.hotel.config.HotelConfigurationProperties;

@Component
@RequiredArgsConstructor
public class HotelConnector {

    private final RestTemplate restTemplate;

    private final HotelConfigurationProperties hotelConfigurationProperties;

    @Value("${server.address}")
    private String serverAddress;

    @Nullable
    public GetRoomResponse getRoom(String roomId) {

        var uri = UriComponentsBuilder.fromUriString(hotelConfigurationProperties.getRoomUrl())
                .port(hotelConfigurationProperties.getPort())
                .scheme("http")
                .host(serverAddress)
                .pathSegment(roomId)
                .build()
                .toUri();

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, GetRoomResponse.class);

        if (responseEntity == null
                || responseEntity.getBody() == null) {

            return null;
        }

        return responseEntity.getBody();
    }

    @Nullable
    public GetBookingsResponse getBookings(String customerId,
                                           String roomId) {

        var uri = UriComponentsBuilder.fromUriString(hotelConfigurationProperties.getBookingsUrl())
                .port(hotelConfigurationProperties.getPort())
                .scheme("http")
                .host(serverAddress)
                .queryParam("customerId", customerId)
                .queryParam("roomId", roomId)
                .build()
                .toUri();

        var responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, GetBookingsResponse.class);

        if (responseEntity == null
                || responseEntity.getBody() == null) {

            return null;
        }

        return responseEntity.getBody();
    }

}
