package ru.prilepskiy.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeacherRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeacherRest teacherRest;


    @Test
    public void echo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/teacher/echo"))
            .andDo(MockMvcResultHandlers.print()) //результат в лог
            .andExpect(MockMvcResultMatchers.status().isOk()) //expect 200
            .andExpect(content().string(containsString("echo")));
    }

    //Тест не работает т.к. приложение не допилено.
    @Test
    public void search() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/teacher/search")
            .param("schoolId", "1"))
            .andDo(MockMvcResultHandlers.print())
            // проверить body
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
