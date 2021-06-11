package com.acme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;

import com.acme.HelloWorldClient;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@Singleton
public class StartupService {
    private ExecutorService executor;
    private static int MAX_POOL_SIZE = 1;
    MyThreadListener listener;
    HelloWorldClient client;
    public StartupService() {
        super();
    }
    void onStart(@Observes StartupEvent ev) {               
        executor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        executor.execute(new MyThreadListener(client));
    }

    void onStop(@Observes ShutdownEvent ev) {               
        listener.stop();
    }
    
   
}
