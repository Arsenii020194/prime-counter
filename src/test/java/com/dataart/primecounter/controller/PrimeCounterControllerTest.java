package com.dataart.primecounter.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PrimeCounterControllerTest {

    @Autowired
    private PrimeCounterController primeCounterController;

    @Test
    public void whenLimitSetReturn200() {
        var response = primeCounterController.getPrimeByLimit(10);
        CollectionUtils.isEqualCollection((Collection<?>) Objects.requireNonNull(response.getBody()), List.of(1, 2, 3, 5, 7));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void whenLimitNullThenTrowInvalid() {
        assertThrows(ConstraintViolationException.class, () -> primeCounterController.getPrimeByLimit(null));
    }

    @Test
    public void whenLimit0ThenReturn404() {
        var response = primeCounterController.getPrimeByLimit(0);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}