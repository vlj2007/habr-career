package my.code.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import my.code.api.JsonValidator;

import java.io.FileReader;
import java.io.IOException;

/**
 * Класс для проверки валидации результата.
 * Определяет метод для валидации.
 *
 * @author Vlj2007
 * @version 0.1
 */

public class GsonJsonValidator implements JsonValidator {
    private final Gson gson = new Gson();

    /**
     * Проверки валидации результата.
     *
     * @param filename имя файла.
     * @return возвращаем true или false, если файл валиден или нет
     * @throws JsonSyntaxException если в синтаксе найдена ошибка.
     * @throws IOException         если ошибка ввода и вывода.
     */

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
