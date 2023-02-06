package com.dent.utils;

import com.dent.model.enums.Role;
import org.springframework.core.convert.converter.Converter;

public class RoleEnumConverter implements Converter<String, Role> {
    @Override
    public Role convert(String source) {
        try {
            return Role.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
