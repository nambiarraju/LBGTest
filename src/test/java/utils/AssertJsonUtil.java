package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class AssertJsonUtil {
    //Utility class to store all the json assertion utilities at one place.
    static String currentDirectory = System.getProperty("user.dir");
    static String dataFolder = "\\src\\test\\Resources\\Data\\ExpectedJson\\";
    static  String fileExtension = ".json";

    //Method to compare the entire expected json which is stored in a file with response.
    //This should give complete confidence that none of the values have changed.
    //Fields which are varying such as time and ID can be ignored and then rest of the json can be verified with selected API.
    public static void compareJsonResponseToFile(String response, String filename){
        String filepath = currentDirectory+dataFolder+filename + fileExtension;
        try {
            assertThatJson(response).isEqualTo(
                    new String(Files.readAllBytes(Paths.get(filepath))));

        } catch (Exception e) {
            System.err.println("Exception caught"+e.getMessage());
        }
    }
}
