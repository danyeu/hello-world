package com.github.danyeu.hello;

import dev.openfeature.contrib.providers.flagd.FlagdOptions;
import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import dev.openfeature.sdk.Client;
import dev.openfeature.sdk.OpenFeatureAPI;
import dev.openfeature.sdk.providers.memory.Flag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;


@SpringBootApplication
public class Application {

    private static HashMap<String, Flag<?>> flags;
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static OpenFeatureAPI api;
    private static Client client;


    public static void main(String[] args) {

        // createFlags();
        flags = new HashMap<>(); // remove
        createApi();
        createClient();

        SpringApplication.run(Application.class, args);

    }

    private static void createFlags() {
        flags = new HashMap<>();
        logger.info("enter: creating flags");
        flags.put("hey", Flag.builder()
                .variant("on", true)
                .variant("off", false)
                .defaultVariant("off")
                .build()
        );
        logger.info("exit: flags created");

    }

    private static void createApi() {
         api = OpenFeatureAPI.getInstance();
         api.setProvider(new FlagdProvider(FlagdOptions.builder().host("localhost").port(8081).build()));
    }

    private static void createClient() {
        client = api.getClient();
    }

    public static boolean getBooleanFlag(String flagName) {
        logger.info("getBooleanFlag: " + flagName);
        return client.getBooleanValue(flagName, false);
    }

}
