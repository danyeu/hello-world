package com.github.danyeu.hello;

import dev.openfeature.contrib.providers.flagd.FlagdOptions;
import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static OpenFeatureAPI api;
    private static Client client;

    public static void main(String[] args) {
        createApi();
        createClient();
        SpringApplication.run(Application.class, args);
    }

    private static void createClient() {
        client = api.getClient();
    }

    private static void createApi() {
         api = OpenFeatureAPI.getInstance();
         api.setProviderAndWait(getFlagdProvider());
    }

    private static FlagdProvider getFlagdProvider() {
        FlagdOptions options = FlagdOptions.builder()
                .host("flagd")
                .port(8013)
                .deadline(5000)
                .build();
        return new FlagdProvider(options);
    }


    public static boolean getBooleanFlag(String flagName) {
        logger.info("getBooleanFlag: " + flagName);
        return client.getBooleanValue(flagName, false);
    }

}
