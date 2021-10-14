/*
 * Copyright (c) 2021.
 */

package com.severalcircles.flamesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

//import net.dv8tion.jda.api.entities.User;

/**
 * Main class for the Flames API
 */
@SpringBootApplication
public class FlamesAPI {
    /**
     * Starts the API
     */
    public static void main(String args[]) {
        Logger.getGlobal().log(Level.INFO, "Searching for Flames Data");
        FlamesDataConnection.prepare();
        Logger.getGlobal().log(Level.INFO, "Starting API");
        SpringApplication.run(FlamesAPI.class, args);
    }

    /**
     *
     * @param id Discord User ID
     * @return String with link to the user data in the API
     */
    public static String getUserDataLink(String id) {
        return "https://flamesapi.severalcircles.com/user/" + id;
    }

}
