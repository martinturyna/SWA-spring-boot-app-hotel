package swa.hotel.converter;

import swa.hotel.api.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.getName();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {

        var gender = Gender.getGenderByCode(dbData);

        if (gender == null) {
            throw new IllegalArgumentException("Unknown database value:" + dbData);

        }

        return gender;
    }

}
