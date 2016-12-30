package me.liliput.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class ShortUrlControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateShortUrl() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/v1/shorten/url")
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content("{" +
                "\"domain\":\"localhost:8080/\"," +
                "\"path\":\"abcd\"," +
                "\"originUrl\":\"www.naver.com\"" +
                "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(200)))
                .andReturn();

        log.debug("{}", result.getResponse().getContentAsString());

    }
}