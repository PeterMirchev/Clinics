package com.dent.configuration;

import com.dent.utils.converter.RoleEnumConverter;
import com.dent.utils.converter.UserTypeEnumConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ApplicationBeenConfiguration implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new UserTypeEnumConverter());
        registry.addConverter(new RoleEnumConverter());
    }


}
