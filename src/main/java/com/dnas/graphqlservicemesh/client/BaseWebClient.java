package com.dnas.graphqlservicemesh.client;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class BaseWebClient<T> {

    T clientConfiguration;

    public BaseWebClient(T clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }

    @Bean
    public WebClient webClient() {
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
            .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(getClientInMemorySize()))
            .build();
        return WebClient.builder()
            .baseUrl(getClientUrl())
            .exchangeStrategies(strategies)
            .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
            .build();
    }

    private HttpClient getHttpClient() {
        return HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, getClientConnectTimeout())
            .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(getClientReadTimeout()))
                .addHandlerLast(new WriteTimeoutHandler(getClientWriteTimeout())));
    }

    protected abstract int getClientInMemorySize();

    protected abstract String getClientUrl();

    protected abstract int getClientConnectTimeout();

    protected abstract int getClientReadTimeout();

    protected abstract int getClientWriteTimeout();
}
