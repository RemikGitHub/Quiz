package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import game.Question;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

    public static List<Question> getQuestionListFromJson(String path){

        List<Question> questions = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            questions = Arrays.asList(mapper.readValue(Paths.get(path).toFile(), Question[].class));
        } catch (
                IOException e) {
            System.out.println("Input json file Error!");
            e.printStackTrace();
        }

        return questions;
    }
}
