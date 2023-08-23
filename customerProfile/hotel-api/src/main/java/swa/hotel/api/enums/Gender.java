package swa.hotel.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Gender {

    MALE("M"),
    FEMALE("F"),
    OTHER("O"),
    ;

    @JsonValue
    private String name;

    @Nullable
    @JsonCreator
    public static Gender getGenderByCode(String code) {

        if (StringUtils.isBlank(code)) {
            return null;
        }

        return Arrays.stream(Gender.values()).filter(value -> StringUtils.equals(value.getName(), code))
                .findFirst()
                .orElse(OTHER);
    }

}
