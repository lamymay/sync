package com.arc.core.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanTest {

    private static final Logger log = LoggerFactory.getLogger(BeanTest.class);

    public String echo(String message) {
        log.info("{}-{}", System.currentTimeMillis(), message);
        return "" + message;
    }

}
