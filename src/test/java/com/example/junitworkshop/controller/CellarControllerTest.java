package com.example.junitworkshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import com.example.junitworkshop.service.CellarService;

@RunWith(MockitoJUnitRunner.class)
public class CellarControllerTest {
    @Mock
    private CellarService cellarService;
    @InjectMocks
    private CellarController cellarController;

    @Test(expected = ResponseStatusException.class)
    public void testAbsentCellar() {
        // given
        when(cellarService.findCellar(any())).thenReturn(Optional.empty());

        // when
        cellarController.getCellar("test cellar");

        // then exception
    }
}