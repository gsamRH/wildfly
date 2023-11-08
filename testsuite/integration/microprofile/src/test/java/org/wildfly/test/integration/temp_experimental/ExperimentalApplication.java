package org.wildfly.test.integration.temp_experimental;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.config.ConfigValueConfigSource;
import io.smallrye.config.SmallRyeConfig;
import jakarta.ws.rs.core.Application;

public class ExperimentalApplication extends Application {

    ConfigValueConfigSource cfgValueCfgSrc;
    SmallRyeConfig smallRyeConfig;

    //Experimental annotation
    @RunOnVirtualThread
    private void method() {
        // ConfigValueConfigSource is annotated with @Experimental
        // Although the field is null, we are not calling the method but
        // the usage should still be detected on deployment
        cfgValueCfgSrc.getConfigValue("x");

        // This method is annotated with @Experimental
        smallRyeConfig.isPropertyPresent("y");
    }
}
