package com.dnas.graphqlservicemesh.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * The type Client properties.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientProperties {
    String url;
    Integer connectTimeout;
    Integer readTimeout;
    Integer writeTimeout;
    Integer inMemorySize;

    String test;
}
