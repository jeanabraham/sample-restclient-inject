package com.acme;

import javax.enterprise.context.ApplicationScoped;

import io.cloudevents.CloudEvent;
import org.slf4j.Logger;
import com.acme.HelloWorldClient;

import org.slf4j.LoggerFactory;

import io.cloudevents.CloudEvent;


@ApplicationScoped 
public class MyThreadListener implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(MyThreadListener.class);
    
    HelloWorldClient client;

    private boolean running = true;

    public MyThreadListener(HelloWorldClient client )  {
        this.client = client;
    }   

    @Override
    public void run() {
        client.emit(new String("hello"));
    }


    public void stop() {
        logger.info ("Stop thread");
        running = false;
    }


}
