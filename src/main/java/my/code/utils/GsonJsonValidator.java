package my.code.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import my.code.api.JsonValidator;

import java.io.FileReader;
import java.io.IOException;

public class GsonJsonValidator implements JsonValidator {
    private final Gson gson = new Gson();

    @Override
    public boolean validate(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            gson.fromJson(reader, Object.class);
            System.out.println("JSON валиден");
            return true;
        } catch (JsonSyntaxException | IOException e) {
            System.err.println("Некорректный JSON: " + e.getMessage());
            return false;
        }
    }
}
