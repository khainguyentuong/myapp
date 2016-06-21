package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(final String... args) throws IOException {
        final String configLocation = System.getProperty("myapp.config.file");
        final File confFile = configLocation==null ?
                new File("./conf/conf.properties") :
                new File(configLocation);

        final Properties properties = new Properties();

        properties.load(Files.newInputStream(confFile.toPath()));

        logger.debug(String.format("The port is %s\n", properties.getProperty("port")));
    }

}