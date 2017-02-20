package com.github.MaryHrisanfova.BibliographySystem.utilities;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mariia_Khrisanfova
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    private Lock lock = new ReentrantLock();
    private final AtomicInteger activeSessions;

    public SessionListener() {
        super();
        activeSessions = new AtomicInteger();
    }

    @Override
    public void sessionCreated(final HttpSessionEvent event) {
        lock.lock();
        try {
            event.getSession().setMaxInactiveInterval(30 * 60); //in seconds
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent event) {
        synchronized (this) {
            activeSessions.decrementAndGet();
        }
    }
}
