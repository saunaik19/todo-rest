package com.saurabh.todo.rest.webservice.jwt.util;

import io.jsonwebtoken.Clock;


import java.util.Date;
public class DefaultClock implements Clock {

    /**
     * Default static instance that may be shared.  It is thread-safe.
     */
    public static final Clock INSTANCE = new DefaultClock();

    /**
     * Simply returns <code>new {@link Date}()</code>.
     *
     * @return a new {@link Date} instance.
     */
    @Override
    public Date now() {
        return new Date();
    }
}