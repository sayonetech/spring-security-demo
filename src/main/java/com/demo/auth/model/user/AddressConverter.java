package com.demo.auth.model.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<AddressType, String> {
    @Override
    public String convertToDatabaseColumn(AddressType attribute) {
        if(attribute == null) {
            return null;
        }
        return attribute.getName();
    }

    @Override
    public AddressType convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }

        return Stream.of(AddressType.values())
                .filter(c -> c.getName().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
