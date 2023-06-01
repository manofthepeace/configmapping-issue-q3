package org.acme;

import java.util.Optional;

import org.acme.MyConfig.Property;

import io.quarkus.runtime.Startup;

@Startup
public class GreetingResource {

    Optional<Property> props;

    GreetingResource(MyConfig conf) {
        props = conf.property();
    }

}
