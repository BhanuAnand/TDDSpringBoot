package com.example.todosample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
public class ToDoControllerTest {

    @MockBean
    ToDoService toDoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllToDos() throws Exception {

        List<ToDo> toDoList = List.of(
                ToDo.builder().id(1L).text("Task 1").completed(true).build(),
                ToDo.builder().id(2L).text("Task 2").completed(false).build()
        );

        when(toDoService.findAllToDos()).thenReturn(toDoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2))).andDo(print());

    }

}
