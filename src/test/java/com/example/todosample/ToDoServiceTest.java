package com.example.todosample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceTest {

    @InjectMocks
    ToDoService toDoService;

    @Mock
    ToDoRepository toDoRepository;

    @Test
    void getAllToDos(){

        List<ToDo> toDoList = List.of(
                ToDo.builder().id(1L).text("Task 1").completed(true).build(),
                ToDo.builder().id(2L).text("Task 2").completed(false).build()
        );

        when(toDoRepository.findAll()).thenReturn(toDoList);

        assertEquals(2, toDoService.findAllToDos().size());

    }


}
