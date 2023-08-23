package swa.hotel.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetTestResponse {

    private String message;
    private String message2;

    private LocalDateTime time;

}
