package com.batch130.config;

import com.batch130.payload.mappers.EntryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateObjectBean {

    @Bean
    public EntryMapper entryMapper(){
        return new EntryMapper();
    }
}
