package com.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.runtime.Startup;

@Startup
@RegisterRestClient
@ApplicationScoped
public interface HelloWorldClient {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    void emit(String str);
}
