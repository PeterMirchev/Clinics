package com.dent.utils.converter;

import com.dent.model.enums.UserType;
import org.springframework.core.convert.converter.Converter;


public class UserTypeEnumConverter implements Converter<String, UserType> {
    @Override
    public UserType convert(String source) {
        try {
            return UserType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
