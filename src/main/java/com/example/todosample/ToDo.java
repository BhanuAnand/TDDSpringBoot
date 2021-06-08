package com.example.todosample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "todo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ToDo {

    @Id
    private long id;
    private String text;
    private boolean completed;

}
