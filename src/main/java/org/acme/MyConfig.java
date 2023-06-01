package org.acme;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;
import io.smallrye.config.WithParentName;

@StaticInitSafe
@ConfigMapping(prefix = "my")
public interface MyConfig {

    @WithParentName
    Optional<Property> property();

    interface Property {
        Test1 test1();

        Test2 test2();

        Test3 test3();

        interface Test1 {
            @WithName("test1-test1")
            Duration test1();

            @WithName("test2-test2")
            Duration test2();
        }

        interface Test2 {
            @WithName("test-size")
            @WithDefault("1000")
            Integer testSize();

        }

        interface Test3 {
            @WithName("valid")
            List<Integer> validStuff();
        }
    }
}
