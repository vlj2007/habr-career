package my.code.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import my.code.api.JsonFileWriter;
import my.code.exception.JsonWriteException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс для записи результата в файл.
 * Определяет метод для записи в файл.
 *
 * @author Vlj2007
 * @version 0.1
 */

public class GsonJsonFileWriter<T> implements JsonFileWriter<T> {
    private final Gson gson;

    public GsonJsonFileWriter() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Запись результата в файл с заданными параметрами.
     *
     * @param data     список компаний
     * @param filename название файла
     * @throws JsonWriteException если данные не найдены
     */

    @Override
    public void write(List<T> data, String filename) throws JsonWriteException {
        String jsonString = gson.toJson(data);
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(jsonString);
            System.out.println("Данные успешно сохранены в файл: " + filename);
        } catch (IOException e) {
            throw new JsonWriteException("Ошибка при сохранении файла: " + filename, e);
        }
    }
}