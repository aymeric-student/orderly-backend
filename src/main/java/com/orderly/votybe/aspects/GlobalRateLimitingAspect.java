package com.orderly.votybe.aspects;

import com.orderly.votybe.exceptions.errors.RateLimitException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class GlobalRateLimitingAspect {

    private final Map<String, List<Long>> requestTimes = new ConcurrentHashMap<>();

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object rateLimitGlobal(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = "GLOBAL_RATE_LIMIT";

        long now = System.currentTimeMillis();
        requestTimes.putIfAbsent(key, new ArrayList<>());

        List<Long> times = requestTimes.get(key);
        times.removeIf(time -> now - time > 10_000);

        if (times.size() >= 3) {
            throw new RateLimitException("Global Rate limit exceeded");
        }

        times.add(now);
        return joinPoint.proceed();
    }
}

