package org.example;


import lombok.*;
import lombok.experimental.Accessors;
import java.sql.Timestamp;

@Setter
@Getter
@Accessors(chain = true)
@ToString
@AllArgsConstructor

public class Lesson {
    private int id;
    private String name;
    private Homework homework;
}
