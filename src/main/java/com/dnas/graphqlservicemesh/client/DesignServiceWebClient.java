package com.dnas.graphqlservicemesh.client;

import com.dnas.graphqlservicemesh.configuration.DesignServiceConfiguration;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DesignServiceWebClient extends BaseWebClient<DesignServiceConfiguration> {

    public DesignServiceWebClient(DesignServiceConfiguration designServiceConfiguration) {
        super(designServiceConfiguration);
    }

    @Override
    protected int getClientInMemorySize() {
        return clientConfiguration.getClient().getInMemorySize();
    }

    @Override
    protected String getClientUrl() {
        return clientConfiguration.getClient().getUrl();
    }

    @Override
    protected int getClientConnectTimeout() {
        return clientConfiguration.getClient().getConnectTimeout();
    }

    @Override
    protected int getClientReadTimeout() {
        return clientConfiguration.getClient().getReadTimeout();
    }

    @Override
    protected int getClientWriteTimeout() {
        return clientConfiguration.getClient().getWriteTimeout();
    }

    public String getTest(){
        return clientConfiguration.getClient().getTest();
    }
}
