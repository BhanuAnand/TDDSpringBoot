package com.example.todosample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ToDoRepositoryTest {

    @Autowired
    ToDoRepository toDoRepository;

    @Test
    void getAllToDos(){
        assertEquals(2, toDoRepository.findAll().size());
    }
}
