package com.niceben.projectmonitor2;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectMonitor2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMonitor2Application.class, args);
    }


    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer() {
        return registry -> registry.config().commonTags("application", "prometheus-demo");
    }
}
