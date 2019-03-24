package com.nolik.reactive.twitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Twit {
    @Id
    private String id;

    private String userName;

    private String text;
}


