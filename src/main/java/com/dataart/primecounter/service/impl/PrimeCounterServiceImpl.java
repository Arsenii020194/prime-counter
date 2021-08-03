package com.dataart.primecounter.service.impl;

import com.dataart.primecounter.service.PrimeCounterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeCounterServiceImpl implements PrimeCounterService {

    @Override
    public List<Integer> getPrimeByLimit(Integer limit) {
        var result = new ArrayList<Integer>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    protected boolean isPrime(Integer n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }
}
