package com.dnas.graphqlservicemesh;

import com.dnas.graphqlservicemesh.configuration.DesignServiceConfiguration;
import com.dnas.graphqlservicemesh.configuration.LicenseConfiguration;
import com.dnas.graphqlservicemesh.configuration.RedBoxConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RedBoxConfiguration.class, LicenseConfiguration.class, DesignServiceConfiguration.class})
public class GraphqlMeshServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlMeshServiceApplication.class, args);
    }

}
