package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by dman on 8/30/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleWebTest {

    @Test(expected=HttpClientErrorException.class)
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://localhost:8080/bogusPage", String.class);
            fail("Should result in HTTP 404");
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
            throw e;
        }
    }
}
