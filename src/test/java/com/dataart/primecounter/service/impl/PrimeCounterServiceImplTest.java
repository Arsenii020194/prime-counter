package com.dataart.primecounter.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrimeCounterServiceImplTest {

    private final PrimeCounterServiceImpl primeCounterService = new PrimeCounterServiceImpl();


    @Test
    public void isPrimeTest() {
        assert !primeCounterService.isPrime(1);
        assert primeCounterService.isPrime(2);
        assert primeCounterService.isPrime(3);
        assert !primeCounterService.isPrime(4);
        assert primeCounterService.isPrime(5);
        assert !primeCounterService.isPrime(6);
        assert !primeCounterService.isPrime(851);
    }

    @Test
    public void isPrimeByLimitTest() {
        CollectionUtils.isEqualCollection(List.of(1, 2, 3, 5, 7), primeCounterService.getPrimeByLimit(10));
    }
}