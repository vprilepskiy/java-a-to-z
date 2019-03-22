package ru.prilepskiy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import ru.prilepskiy.config.ContextAuthentication;
import ru.prilepskiy.entity.UserEntity;
import ru.prilepskiy.service.UserService;
import java.util.Optional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SecureController.class)
public class SecureControllerTest {

    private String STRING = "text";
    private String TRUE = Boolean.TRUE.toString();
    private String FALSE = Boolean.FALSE.toString();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    ContextAuthentication contextAuthentication;

    @Test
    @WithMockUser(username = "user")
    public void getPrincipal() throws Exception {
        // run REST request
        this.mockMvc.perform(get("/auth/user")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(content().string("user"))
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    @WithMockUser(username = "user")
    public void login() throws Exception {
        // mock auth
        BDDMockito.given(this.contextAuthentication.auth(STRING, STRING))
            .willReturn(true);
        // run REST request
        this.mockMvc.perform(post("/auth/login")
            .with(csrf())
            .param("login",STRING)
            .param("password",STRING)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(content().string(TRUE))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user")
    public void login_error() throws Exception {
        // mock auth
        BDDMockito.given(this.contextAuthentication.auth(STRING, STRING))
            .willReturn(false);
        // run REST request
        this.mockMvc.perform(post("/auth/login")
            .with(csrf())
            .param("login",STRING)
            .param("password",STRING)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(content().string(FALSE))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user")
    public void registration() throws Exception {
        // mock userService
        BDDMockito.given(this.userService.findByLogin("user"))
            .willReturn(Optional.empty());
        // mock auth
        BDDMockito.given(this.contextAuthentication.auth(STRING, STRING))
            .willReturn(true);

        // run REST request
        this.mockMvc.perform(post("/auth/registration")
            .with(csrf())
            .param("login", STRING)
            .param("password",STRING)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(content().string(TRUE))
            .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user")
    public void registration_error() throws Exception {
        // mock userService
        BDDMockito.given(this.userService.findByLogin("user"))
            .willReturn(Optional.of(new UserEntity()));
        // mock auth
        BDDMockito.given(this.contextAuthentication.auth("user", "password"))
            .willReturn(true);

        // run REST request
        this.mockMvc.perform(post("/auth/registration")
            .with(csrf())
            .param("login","user")
            .param("password","password")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError());
    }
}