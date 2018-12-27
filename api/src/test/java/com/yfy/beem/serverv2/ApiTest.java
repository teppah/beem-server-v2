package com.yfy.beem.serverv2;

import com.yfy.beem.serverv2.controller.MainApiController;
import com.yfy.beem.serverv2.dao.UserDao;
import com.yfy.beem.serverv2.dao.UserRepository;
import com.yfy.beem.serverv2.datamodel.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for the REST API Controller.
 * @see com.yfy.beem.serverv2.controller.MainApiController
 * */
@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = MainApiController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ApiTest {
//    @Autowired
    private MockMvc mvc;
    @Autowired
    private MainApiController controller;
    @Autowired
    private WebApplicationContext context;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserDao userDao;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void dummyTest() {

    }

    @Test
    public void emptyUsersTest() throws Exception {
        mvc.perform(get("/api/users/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void addUserTest() throws Exception {
//        User user = User.builder().build();
//        mvc.perform(post("/api/users/", user));
//        mvc.perform(get("/api/users/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString(user.toString())));
    }
}
