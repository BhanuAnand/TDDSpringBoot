package com.example.todosample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getAllToDos(){
        List<ToDo> toDoList = List.of(
                ToDo.builder().id(1L).text("Task 1").completed(true).build(),
                ToDo.builder().id(2L).text("Task 2").completed(false).build()
        );

        assertEquals(testRestTemplate.getForObject("/todos", ToDoList.class), toDoList);
    }
}
