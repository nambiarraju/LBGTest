package utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    //Utility class to read all the config which will be needed by the framework such as common properties, directory values etc.
    private static String baseURI;
    private static int portNumber;
    private static ConfigReader configReader = null;

    final static String configFilePAth = "src\\test\\Resources\\Config\\Config.json";

    public String getBaseURI() {
        return baseURI;
    }

    public int getPortNumber() {
        return portNumber;
    }



    private ConfigReader() {
        readConfig();
    }

    public static ConfigReader getConfigReader() {
        if (configReader == null)
            configReader = new ConfigReader();

        return configReader;
    }

    public static void readConfig() {
        String projectDir = System.getProperty("user.dir");
        DocumentContext parsedJson ;
        try {
            parsedJson = JsonPath.parse(new File(projectDir + "\\" + configFilePAth));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseURI = parsedJson.read("$.BaseURI");
        portNumber = parsedJson.read("$.Port");
    }

}
