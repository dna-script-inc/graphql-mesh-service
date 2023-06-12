package com.dnas.graphqlservicemesh.client;

import com.dnas.graphqlservicemesh.configuration.ClientProperties;
import com.dnas.graphqlservicemesh.configuration.RedBoxConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RedBoxServiceWebClientTest {

    @Mock
    private RedBoxConfiguration redBoxConfiguration;

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

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
        when(redBoxConfiguration.getClient()).thenReturn(clientProperties);
        RedBoxServiceWebClient webClient = new RedBoxServiceWebClient(redBoxConfiguration);

        // Act
        String actualTestValue = webClient.getTest();

        // Assert
        assertEquals(expectedTestValue, actualTestValue);
    }
}
