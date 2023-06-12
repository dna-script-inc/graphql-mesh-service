package com.dnas.graphqlservicemesh.client;

import com.dnas.graphqlservicemesh.configuration.ClientProperties;
import com.dnas.graphqlservicemesh.configuration.DesignServiceConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DesignServiceWebClientTest {

    @Mock
    private DesignServiceConfiguration designServiceConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClientInMemorySize_ReturnsConfiguredValue() {
        // Arrange
        int expectedInMemorySize = 1000;
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setInMemorySize(expectedInMemorySize);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        int actualInMemorySize = webClient.getClientInMemorySize();

        // Assert
        assertEquals(expectedInMemorySize, actualInMemorySize);
    }

    @Test
    void getClientUrl_ReturnsConfiguredValue() {
        // Arrange
        String expectedUrl = "http://example.com";
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setUrl(expectedUrl);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        String actualUrl = webClient.getClientUrl();

        // Assert
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void getClientConnectTimeout_ReturnsConfiguredValue() {
        // Arrange
        int expectedConnectTimeout = 5000;
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setConnectTimeout(expectedConnectTimeout);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        int actualConnectTimeout = webClient.getClientConnectTimeout();

        // Assert
        assertEquals(expectedConnectTimeout, actualConnectTimeout);
    }

    @Test
    void getClientReadTimeout_ReturnsConfiguredValue() {
        // Arrange
        int expectedReadTimeout = 10000;
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setReadTimeout(expectedReadTimeout);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        int actualReadTimeout = webClient.getClientReadTimeout();

        // Assert
        assertEquals(expectedReadTimeout, actualReadTimeout);
    }

    @Test
    void getClientWriteTimeout_ReturnsConfiguredValue() {
        // Arrange
        int expectedWriteTimeout = 15000;
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setWriteTimeout(expectedWriteTimeout);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        int actualWriteTimeout = webClient.getClientWriteTimeout();

        // Assert
        assertEquals(expectedWriteTimeout, actualWriteTimeout);
    }

    @Test
    void getTest_ReturnsConfiguredValue() {
        // Arrange
        String expectedTestValue = "Test Value";
        ClientProperties clientProperties = new ClientProperties();
        clientProperties.setTest(expectedTestValue);
        when(designServiceConfiguration.getClient()).thenReturn(clientProperties);
        DesignServiceWebClient webClient = new DesignServiceWebClient(designServiceConfiguration);

        // Act
        String actualTestValue = webClient.getTest();

        // Assert
        assertEquals(expectedTestValue, actualTestValue);
    }
}

