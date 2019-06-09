package com.poc.redis.poc.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "id")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String document;

    private String description;

}
