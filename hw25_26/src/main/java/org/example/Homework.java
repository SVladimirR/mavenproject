package org.example;

import lombok.*;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@ToString
@AllArgsConstructor


public class Homework {
    private int id;
    private String name;
    private String description;

}
