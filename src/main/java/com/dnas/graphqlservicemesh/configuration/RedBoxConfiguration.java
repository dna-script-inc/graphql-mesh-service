package com.dnas.graphqlservicemesh.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "redbox-service")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RedBoxConfiguration {
    @NestedConfigurationProperty
    ClientProperties client;


}
