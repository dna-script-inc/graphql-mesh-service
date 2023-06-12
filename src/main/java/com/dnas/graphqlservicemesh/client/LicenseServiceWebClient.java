package com.dnas.graphqlservicemesh.client;

import com.dnas.graphqlservicemesh.configuration.LicenseConfiguration;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LicenseServiceWebClient extends BaseWebClient<LicenseConfiguration> {

    public LicenseServiceWebClient(LicenseConfiguration licenseConfiguration) {
        super(licenseConfiguration);
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
