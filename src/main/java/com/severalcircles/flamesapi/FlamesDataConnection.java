package com.severalcircles.flamesapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlamesDataConnection {
    public static final File flamesDirectory = new File(System.getProperty("user.dir") + "/Flames");
    static final File userDirectory = new File(flamesDirectory.getAbsolutePath() + "/user");
    static final File guildDirectory = new File(flamesDirectory.getAbsolutePath() + "/guild");
    static void prepare() {
            if (!flamesDirectory.exists() | !userDirectory.exists() | guildDirectory.exists()) {
                Logger.getGlobal().log(Level.SEVERE, "Cannot find Flames data. Make sure you run the Flames jar first.");
                System.exit(1);
            }
    }
    public static Properties[] getUser(String id) throws IOException {
        File udir = new File(userDirectory.getAbsolutePath() + "/" + id);
        File userfl = new File(udir.getAbsolutePath() + "/user.fl");
        File stats2 = new File(udir.getAbsolutePath() + "/stats.fl");
        File funfacts = new File(udir.getAbsolutePath() + "/funfacts.fl");
        FileInputStream inputStream1 = new FileInputStream(userfl);
        FileInputStream inputStream2 = new FileInputStream(stats2);
        FileInputStream inputStream3 = new FileInputStream(funfacts);
        Properties p1 = new Properties();
        Properties p2 = new Properties();
        Properties p3 = new Properties();
        p1.load(inputStream1);
        p2.load(inputStream2);
        p3.load(inputStream3);
        return new Properties[]{p1, p2, p3};

    }
}
