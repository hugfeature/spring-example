package com.example.springweb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class NeoProperties {
    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public Object getDescription() {
        return description;
    }
}
