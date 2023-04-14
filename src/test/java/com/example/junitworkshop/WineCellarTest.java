package com.example.junitworkshop;

import static io.restassured.RestAssured.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@SpringBootTest(classes = WineCellar.class, webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class WineCellarTest {
    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void sanityCheck() {
        when()
                .get("/")
                .then()
                .statusCode(200);
    }

    @Test
    @Ignore("We're not insane")
    public void insanityCheck() {
        when()
                .get("/")
                .then()
                .statusCode(500);
    }
}